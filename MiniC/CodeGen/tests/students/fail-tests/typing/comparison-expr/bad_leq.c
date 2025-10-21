#include "printlib.h"

int main() {
        int x;
        float y;
        println_bool(x<=y);
        return 0;
}

// EXPECTED
// EXITCODE 2
// In function main: Line 6 col 21: type mismatch for relational operands: integer and float
