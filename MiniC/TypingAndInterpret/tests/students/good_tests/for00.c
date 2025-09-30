#include "printlib.h"

int main() {
    int k;
    for k=2 to 10 by 2
    {println_int(k);}
    return 0;
}

// EXPECTED
// 2
// 4
// 6
// 8
// 10
