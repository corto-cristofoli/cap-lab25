"""
CAP, SSA Intro, Elimination and Optimisations
Helper functions to convert a CFG out of SSA Form
for the Smart Allocator.
"""

from typing import List, Set, Tuple
from Lib import RiscV
from Lib.Graphes import DiGraph
from Lib.CFG import BlockInstr
from Lib.Operands import Register, Offset, DataLocation, S


def generate_smart_move(dest: DataLocation, src: DataLocation) -> List[BlockInstr]:
    """
    Generate a list of move, store and load instructions, depending on
    whether the operands are registers or memory locations.
    This is an helper function for `sequentialize_moves`.
    """
    instr: List[BlockInstr] = []
    if dest != src:
        tmp = S[1]
        if isinstance(dest, Register) and isinstance(src, Register):
            instr.append(RiscV.Instru3A("mv", dest, src))
        elif isinstance(dest, Register) and isinstance(src, Offset):
            instr.append(RiscV.Instru3A("ld", dest, src))
        elif isinstance(dest, Offset) and isinstance(src, Register):
            instr.append(RiscV.Instru3A("sd", src, dest))
        elif isinstance(dest, Offset) and isinstance(src, Offset):
            instr.append(RiscV.Instru3A("ld", tmp, src))
            instr.append(RiscV.Instru3A("sd", tmp, dest))
    return instr


def sequentialize_moves(parallel_moves: Set[Tuple[DataLocation, DataLocation]]
                        ) -> List[BlockInstr]:
    """
    Take a set of parallel moves represented as (destination, source) pairs,
    and return a list of sequential moves which respect the cycles.
    Use the register `tmp` S2 for the cycles.
    Return a corresponding list of RiscV instructions.
    This is an helper function called during SSA exit.
    """
    tmp: Register = S[2]  # S2 is not a general purpose register
    # Build the graph of the moves
    move_graph: DiGraph = DiGraph()
    for dest, src in parallel_moves:
        move_graph.add_edge((src, dest))
    # List for the sequentialized moves to do
    # Convention: in moves we put (dest, src) for each move
    moves: List[Tuple[DataLocation, DataLocation]] = []
    # First iteratively remove all the vetices without successors
    vars_without_successor = {src
                              for src, dests in move_graph.neighbourhoods()
                              if len(dests) == 0}
    while vars_without_successor:
        v = vars_without_successor.pop()
        for src in move_graph.pred(v):
            moves.append((v, src))
            if len(move_graph.graph_dict[src]) == 1:
                vars_without_successor.add(src)
        move_graph.delete_vertex(v)
    # Then handle the cycles
    moves_instr: List[BlockInstr] = []
    cycles: List = move_graph.connected_components()
    for cycle in cycles:
        if len(cycle) > 2:
            previous = tmp
            for v in cycle[::-1]:
                moves.append((previous, v))
                previous = v
            moves.append((previous, tmp))
        if len(cycle) == 2:
            c1, c2 = cycle
            moves_instr.extend(
                [
                    RiscV.Instru3A("xor", c1, c1, c2),
                    RiscV.Instru3A("xor", c2, c1, c2),
                    RiscV.Instru3A("xor", c1, c1, c2),
                ]
            )
    # Transform the moves to do in actual RiscV instructions
    for dest, src in moves:
        instrs = generate_smart_move(dest, src)
        moves_instr.extend(instrs)
    return moves_instr
