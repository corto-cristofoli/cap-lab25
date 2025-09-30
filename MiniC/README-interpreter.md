# MiniC interpreter and typechecker

MIF08 / CAP / CS444 2024-25

# Authors

Corto CRISTOFOLI

# Howto

`make test-interpret FILTER='TypingAndInterpret/tests/provided/examples/test_print_int.c'` for a single run

`make test` to test all the files in `*/tests/*` according to `EXPECTED` results.

You can select the files you want to test by using `make test FILTER='TypingAndInterpret/**/*bad*.c'` (`**` means
"any number of possibly nested directories").

# Test design 

The tests are separated into 3 folders :
- `good_tests` that are the tests that work
- `bad_tests` that are the tests that fail not with the typing
- `bad_typing_tests` that are the tests that fail because of typing



# Known bugs

There is a bug with the fortran-like loop. I think it is due to the fact that gcc can't compile it and I don't
know how to solve it. Moreover the typing isn't working well

