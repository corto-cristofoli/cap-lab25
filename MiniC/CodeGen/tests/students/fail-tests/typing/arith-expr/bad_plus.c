#include "printlib.h"

int main() {
        int x;
        float y,z;
        z = x+y;
        return 0;
}

// EXPECTED
// EXITCODE 2
// In function main: Line 6 col 12: type mismatch for additive operands: integer and float
