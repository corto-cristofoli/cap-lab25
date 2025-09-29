from typing import Dict, Set
from Lib.Operands import Operand, Temporary
from Lib.Statement import Statement, Instruction, regset_to_string
from Lib.CFG import CFG, Block
import copy


class LivenessDataFlow:

    def __init__(self, function, debug=False):
        self._function: CFG = function
        self._debug = debug
        # Live Operands at input and output of blocks
        self._blockin: Dict[Block, Set[Operand]] = {}
        self._blockout: Dict[Block, Set[Operand]] = {}
        # Live Operands at outputs of instructions
        self._liveout: Dict[tuple[Block, Statement], Set[Operand]] = {}

    def run(self):
        self.set_gen_kill()
        if self._debug:
            self.print_gen_kill()

        self.run_dataflow_analysis()
        if self._debug:
            self.print_map_in_out()

        self.fill_liveout()

    def set_gen_kill(self):
        """Set the _gen and _kill field for each block in the function."""
        for blk in self._function.get_blocks():
            self.set_gen_kill_in_block(blk)

    def set_gen_kill_in_block(self, block: Block) -> None:
        gen = set()
        kill = set()
        for i in block.get_all_statements():
            # Reminder: '|' is set union, '-' is subtraction.
            raise NotImplementedError()
        block._gen = gen
        block._kill = kill

    def run_dataflow_analysis(self):
        """Run the dataflow liveness analysis, i.e. compute self._blockin and
        self._blockout based on the ._kill and ._gen fields of individual
        instructions."""
        if self._debug:
            print("Dataflow Analysis")
        # initialisation of all blockout,blockin sets, and def = kill
        for blk in self._function.get_blocks():
            self._blockin[blk] = set()
            self._blockout[blk] = set()
        stable = False
        while not stable:
            # Iterate until fixpoint :
            # make calls to self._function.dataflow_one_step
            stable = True  # CHANGE
        # TODO (lab5) ! (perform iterations until fixpoint).

    def dataflow_one_step(self):
        """Run one iteration of the dataflow analysis. This function is meant
        to be run iteratively until fixpoint."""
        for blk in self._function.get_blocks():
            self._blockout[blk] = set()
            for child_label in blk.get_terminator().targets():
                child = self._function.get_block(child_label)
                self._blockout[blk] = self._blockout[blk] | self._blockin[child]

            self._blockin[blk] = (self._blockout[blk] - blk._kill) | blk._gen

    def fill_liveout(self):
        """Propagate the information from blockout/blockin inside the block
        to get liveset instruction by instructions."""
        for blk in self._function.get_blocks():
            liveset = self._blockout[blk]
            for instr in reversed(blk.get_all_statements()):
                self._liveout[blk, instr] = liveset
                liveset = (liveset - set(instr.defined())) | set(instr.used())

    def print_gen_kill(self):  # pragma: no cover
        print("Dataflow Analysis, Initialisation")
        for i, block in enumerate(self._function.get_blocks()):
            print("block " + str(block._label), ":", i)
            print("gen: " + regset_to_string(block._gen))
            print("kill: " + regset_to_string(block._kill) + "\n")

    def print_map_in_out(self):  # pragma: no cover
        """Print in/out sets, useful for debug!"""
        print("In: {" +
              ", ".join(str(x.get_label()) + ": "
                        + regset_to_string(self._blockin[x])
                        for x in self._blockin.keys()) +
              "}")
        print("Out: {" +
              ", ".join(str(x.get_label()) + ": "
                        + regset_to_string(self._blockout[x])
                        for x in self._blockout.keys()) +
              "}")
