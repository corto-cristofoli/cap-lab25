# MiniC Compiler 
LAB4 (simple code generation), MIF08 / CAP 2022-23

# Authors

Corto Cristofoli

# Contents

Implement everything of tp4a and tp4b.

# Test design 

The tests are separated into different steps, corresponding to the one we have in the tp4. There is also a
`fail-tests` directory to test the errors.

# Design choices

Since the boolean are represented by a 0 or a 1 (all my boolean operator ensure it). I use the XOR operand
with a 1 to compute the not on a boolean :
- `!false = 0 ^ 1 = 1 = true`
- `!true = 1 ^ 1 = 0 = false`

For the integer relational operators, I separate the 2 cases `==` and `!=` from the others (`<`, `<=`, `>`,
`>=`) since they don't need labels and jumps. It is possible to not have any jump for relational by adding
`slt` operation in the `./Lib/RiscV.py` file (I left the code in comments)

## Extensions implementation:

I implemented C like `for` loop, which is pretty straight forward to implement.

The idea I used to minimize the number of jumps between is to reorder them using a Depth First Search on the
CFG.

# Known bugs

No known bugs.

# Checklists

A check ([X]) means that the feature is implemented 
and *tested* with appropriate test cases.

## Code generation

- [X] Number Atom
- [X] Boolean Atom
- [X] Id Atom
- [X] Additive expression
- [X] Multiplicative expression
- [X] UnaryMinus expression
- [X] Or expression
- [X] And expression
- [X] Equality expression
- [X] Relational expression (! many cases -> many tests)
- [X] Not expression

## Statements

- [X] Prog, assignements
- [X] While
- [X] Cond Block
- [X] If
- [X] Nested ifs
- [X] Nested whiles

## Allocation

- [X] Naive allocation
- [X] All in memory allocation
- [X] Massive tests of memory allocation

