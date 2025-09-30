#include "printlib.h"

int main() {
    int i;
    for i=5 to 0 by -1
    {println_int(i);}
    return 0;
}

// EXPECTED
// 5
// 4
// 3
// 2
// 1
// 0
