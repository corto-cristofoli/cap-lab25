from typing import List, Dict
from Lib.Errors import MiniCInternalError
from Lib.Operands import Temporary, Operand, S, Offset, DataLocation, GP_REGS, Register
from Lib.Statement import Instruction
from Lib.Allocator import Allocator
from Lib.FunctionData import FunctionData
from Lib import RiscV
from Lib.Graphes import Graph  # For Graph coloring utility functions


class SmartAllocator(Allocator):

    _igraph: Graph  # interference graph

    def __init__(self, fdata: FunctionData, basename: str, liveness,
                 debug=False, debug_graphs=False):
        self._liveness = liveness
        self._basename: str = basename
        self._debug: bool = debug
        self._debug_graphs: bool = debug_graphs
        super().__init__(fdata)

    def replace(self, old_instr: Instruction) -> List[Instruction]:
        """
        Replace Temporary operands with the corresponding allocated
        physical register (Register) OR memory location (Offset).
        """
        before: List[Instruction] = []
        after: List[Instruction] = []
        new_args: List[Operand] = []
        
        id_reg = 1
        for i, arg in enumerate(old_instr.args()):
            if isinstance(arg, Temporary):
                loc = arg.get_alloced_loc()
                if not isinstance(loc, Register):
                    if not (old_instr.ins.startswith("b")):
                        if i != 0:  # source
                            before.append(RiscV.Instru3A("ld", S[id_reg], loc))
                        elif i == 0:  # destination
                            if not old_instr.is_read_only():
                                after.append(RiscV.Instru3A("sd", S[id_reg], loc))
                    else:
                        before.append(RiscV.Instru3A("ld", S[id_reg], loc))
                    new_args.append(S[id_reg])
                    id_reg += 1
                else:
                    new_args.append(loc)
            else:
                new_args.append(arg)
        # And now return the new list!
        instr = old_instr.with_args(new_args)
        return before + [instr] + after

    def prepare(self) -> None:
        """
        Perform all preparatory steps related to smart register allocation:

        - Dataflow analysis to compute the liveness range of each
          temporary.
        - Interference graph construction.
        - Graph coloring.
        - Associating temporaries with actual locations.
        """
        # Liveness analysis
        self._liveness.run()
        # Interference graph
        self.build_interference_graph()
        if self._debug_graphs:
            print("Printing the interference graph")
            self._igraph.print_dot(self._basename + "interference.dot")
        # Smart Allocation via graph coloring
        self.smart_alloc()

    def build_interference_graph(self) -> None:
        """
        Build the interference graph (in self._igraph).
        Vertices of the graph are temporaries,
        and an edge exists between temporaries iff they are in conflict.
        """
        self._igraph: Graph = Graph()
        # Create a vertex for every temporary
        # There may be temporaries the code does not use anymore,
        # but it does not matter as they interfere with no one.
        for v in self._fdata._pool.get_all_temps():
            self._igraph.add_vertex(v)
        # Iterate over self._liveness._liveout (dictionary containing all
        # live out temporaries for each instruction), and for each conflict use
        # self._igraph.add_edge((t1, t2)) to add the corresponding edge.
        for (block, instr), live in self._liveness._liveout.items():
            for t1 in live:
                for t2 in live:
                    if t1 != t2:
                        self._igraph.add_edge((t1, t2))
            for t1 in live:
                for t2 in instr.defined():
                    if t1 != t2:
                        self._igraph.add_edge((t1, t2))

    def smart_alloc(self) -> None:
        """
        Allocates all temporaries via graph coloring.
        Prints the colored graph if self._debug_graphs is True.

        Precondition: the interference graph _igraph must have been built.
        """
        # Checking the interference graph has been built
        if not self._igraph:
            raise MiniCInternalError("Empty interference graph in the Smart Allocator")
        # Coloring of the interference graph
        coloringreg: Dict[Temporary, int] = self._igraph.color()
        if self._debug_graphs:
            print("coloring = " + str(coloringreg))
            self._igraph.print_dot(self._basename + "_colored.dot", coloringreg)
        # Temporary -> DataLocation (Register or Offset) dictionary,
        # specifying where a given Temporary should be allocated:
        nb_regs = len(GP_REGS)
        alloc_dict: Dict[Temporary, DataLocation] = {
            vertex: GP_REGS[color] if color < nb_regs else self._fdata.fresh_offset()
            for vertex, color in coloringreg.items()
        }
        # Use the coloring `coloringreg` to fill `alloc_dict`.
        # Our version is less than 5 lines of code.
        if self._debug:
            print("Allocation:")
            print(alloc_dict)
        self._fdata._pool.set_temp_allocation(alloc_dict)
