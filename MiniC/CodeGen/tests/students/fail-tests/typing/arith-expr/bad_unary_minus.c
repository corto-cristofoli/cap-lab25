#include "printlib.h"

int main() {
        println_int(-true);
        return 0;
}

// EXPECTED
// EXITCODE 2
// In function main: Line 4 col 20: invalid type for minus operator: boolean
