#include "printlib.h"

int main() {
    int i;
    for i=5 to 0 by 0.5
    {println_int(i);}
    return 0;
}

// EXPECTED
// EXITCODE 2
// In function main: Line 5 col 21: Undefined variable corto
