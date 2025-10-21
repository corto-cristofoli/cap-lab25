#include "printlib.h"

int main() {
        println_bool(1.0);
        return 0;
}

// EXPECTED
// EXITCODE 2
// In function main: Line 4 col 8: invalid type for println_bool statement: float

