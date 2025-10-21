#include "printlib.h"


int main() {
        println_int(4+3-3*2);
        println_int((4+3)*3*2);
        println_int((4+3)-3*2);
        println_int((-4+3)-(-3)*2);
        println_int(3+4%3);
        println_int(5*4%3);
        println_int(5%4*3);
        println_int(-5*(-4)%3);
        return 0;
}

// EXPECTED
// 1
// 42
// 1
// 5
// 4
// 2
// 3
// 2
