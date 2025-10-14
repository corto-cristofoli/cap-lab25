from Lib import RiscV
from Lib.Operands import Temporary, Operand, S
from Lib.Statement import Instruction
from Lib.Allocator import Allocator
from typing import List


class AllInMemAllocator(Allocator):

    def replace(self, old_instr: Instruction) -> List[Instruction]:
        """Replace Temporary operands with the corresponding allocated
        memory location."""
        # numreg = 1
        before: List[Instruction] = []
        after: List[Instruction] = []
        new_args: List[Operand] = []

        for i, arg in enumerate(old_instr.args()):
            if isinstance(arg, Temporary):
                loc = arg.get_alloced_loc()
                if not (old_instr.ins.startswith("b")):
                    if i != 0:  # source
                        before.append(RiscV.Instru3A("ld", S[i + 1], loc))
                    elif i == 0:  # destination
                        if not old_instr.is_read_only():
                            after.append(RiscV.Instru3A("sd", S[i + 1], loc))
                else:
                    before.append(RiscV.Instru3A("ld", S[i + 1], loc))
                new_args.append(S[i + 1])
            else:
                new_args.append(arg)
        new_instr = old_instr.with_args(new_args)
        return before + [new_instr] + after

    def prepare(self) -> None:
        """Allocate all temporaries to memory.
        Invariants:
        - Expanded instructions can use s2 and s3
          (to store the values of temporaries before the actual instruction).
        """
        self._fdata._pool.set_temp_allocation(
            {temp: self._fdata.fresh_offset()
             for temp in self._fdata._pool.get_all_temps()})
