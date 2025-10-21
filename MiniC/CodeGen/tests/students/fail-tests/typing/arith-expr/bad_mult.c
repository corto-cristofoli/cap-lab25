#include "printlib.h"

int main() {
        int x;
        float y,z;
        z = x*y;
        return 0;
}

// EXPECTED
// EXITCODE 2
// In function main: Line 6 col 12: invalid type for multiplicative operands: integer and float
