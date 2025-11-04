"""
CAP, SSA Intro, Elimination and Optimisations
Functions to convert a CFG out of SSA Form.
"""

from typing import cast, List, Set, Tuple
from Lib import RiscV
from Lib.CFG import Block, BlockInstr, CFG
from Lib.Operands import Temporary, Register, Offset, DataLocation, S
from Lib.Statement import AbsoluteJump
from Lib.Terminator import BranchingTerminator, Return, jump2terminator
from Lib.PhiNode import PhiNode
from Lib.Errors import MiniCInternalError
from RegAlloc.SequentializeMoves import sequentialize_moves


def generate_moves_from_phis(phis: List[PhiNode], parent: Block) -> List[BlockInstr]:
    """
    `generate_moves_from_phis(phis, parent)` builds a list of move instructions
    to be inserted in a new block between `parent` and the block with phi nodes
    `phis`.

    This is an helper function called during SSA exit.
    """
    moves: List[BlockInstr] = []
    for phi in phis:
        for sources, var_source in phi.srcs.items():
            if sources == parent.get_label():
                moves.append(RiscV.mv(phi.var, var_source))
    return moves


def exit_ssa(cfg: CFG, is_smart: bool) -> None:
    """
    `exit_ssa(cfg)` replaces phi nodes with move instructions to exit SSA form.

    `is_smart` is set to true when smart register allocation is enabled (Lab 5b).
    """
    block2add = []
    edge2add = []
    edge2remove = []
    for b in cfg.get_blocks():
        phis = cast(List[PhiNode], b.get_phis())  # Use cast for Pyright
        b.remove_all_phis()  # Remove all phi nodes in the block
        parents: List[Block] = b.get_in().copy()  # Copy as we modify it by adding blocks
        for parent in parents:
            moves = generate_moves_from_phis(phis, parent)
            if not moves:
                continue
            match parent.get_terminator():
                case BranchingTerminator() as j:
                    if b.get_label() == j.label_then:
                        new_label = cfg.fdata.fresh_label("phi_node_then")
                        parent.set_terminator(
                            BranchingTerminator(
                                j.cond, j.op1, j.op2, new_label, j.label_else
                            )
                        )
                    elif b.get_label() == j.label_else:
                        new_label = cfg.fdata.fresh_label("phi_node_else")
                        parent.set_terminator(
                            BranchingTerminator(
                                j.cond, j.op1, j.op2, j.label_then, new_label
                            )
                        )
                    else:
                        raise MiniCInternalError(
                            "The parent cannot communicate with this block"
                        )
                case _:
                    new_label = cfg.fdata.fresh_label("phi_node")
                    parent.set_terminator(
                        jump2terminator(RiscV.jump(new_label), new_label)
                    )

            new_block = Block(
                new_label,
                moves,
                jump2terminator(RiscV.jump(b.get_label()), b.get_label()),
            )
            block2add.append(new_block)
            edge2add.append((parent, new_block))
            edge2add.append((new_block, b))
            edge2remove.append((parent, b))

    for b in block2add:
        cfg.add_block(b)
    for a, b in edge2remove:
        cfg.remove_edge(a, b)
    for a, b in edge2add:
        cfg.add_edge(a, b)
