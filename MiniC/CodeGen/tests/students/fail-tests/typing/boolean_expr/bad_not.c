#include "printlib.h"

int main() {
        int x;
        x = 1;
        println_bool(!x);
        return 0;
}

// EXPECTED
// EXITCODE 2
// In function main: Line 6 col 21: invalid type for not operator: integer
