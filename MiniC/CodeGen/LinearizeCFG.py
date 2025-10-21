"""
CAP, CodeGeneration, CFG linearization to a list of statements
"""

from typing import List, Set
from Lib.Statement import Statement, AbsoluteJump, ConditionalJump
from Lib.Terminator import Return, BranchingTerminator
from Lib.CFG import Block, CFG


def ordered_blocks_list(cfg: CFG) -> List[Block]:
    """
    Compute a list of blocks with optimized ordering for linearization.
    """
    ordered_blocks: List[Block] = []
    stack: List[Block] = [cfg.get_block(cfg.get_start())]
    not_seen: set[Block] = set(cfg.get_blocks()) - set(stack)

    while not_seen:
        while stack:
            current_block: Block = stack.pop()
            ordered_blocks.append(current_block)
            match current_block.get_terminator():
                case BranchingTerminator() as j:
                    else_neighbor: Block = cfg.get_block(j.label_else)
                    if else_neighbor in not_seen:
                        stack.append(else_neighbor)
                        not_seen.remove(else_neighbor)
                    then_neighbor: Block = cfg.get_block(j.label_then)
                    if then_neighbor in not_seen:
                        stack.append(then_neighbor)
                        not_seen.remove(then_neighbor)
                case AbsoluteJump() as j:
                    neighbor: Block = cfg.get_block(j.label)
                    if neighbor in not_seen:
                        stack.append(neighbor)
                        not_seen.remove(neighbor)
                case Return():
                    pass
        # the stack could be empty with some unseen blocks...
        if not_seen != set():
            new_start: Block = not_seen.pop()
            stack.append(new_start)

    # return cfg.get_blocks()
    return ordered_blocks


def linearize(cfg: CFG) -> List[Statement]:
    """
    Linearize the given control flow graph as a list of instructions.
    """
    # TODO
    l: List[Statement] = []  # Linearized CFG
    blocks: List[Block] = ordered_blocks_list(cfg)  # All blocks of the CFG
    max_block: int = len(blocks) - 1
    for i, block in enumerate(blocks):
        # 1. Add the label of the block to the linearization
        l.append(block.get_label())
        # 2. Add the body of the block to the linearization
        l.extend(block.get_body())
        # 3. Add the terminator of the block to the linearization
        match block.get_terminator():
            case BranchingTerminator() as j:
                l.append(ConditionalJump(j.cond, j.op1, j.op2, j.label_then))
                if i < max_block and j.label_else == blocks[i + 1].get_label():
                    continue
                l.append(AbsoluteJump(j.label_else))
            case AbsoluteJump() as j:
                if i < max_block and j.label == blocks[i + 1].get_label():
                    # we don't add jump if the two blocks are adjacents
                    continue
                l.append(AbsoluteJump(j.label))
            case Return():
                l.append(AbsoluteJump(cfg.get_end()))
    return l
