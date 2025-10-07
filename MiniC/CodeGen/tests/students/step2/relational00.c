#include "printlib.h"

int main() {
    
    println_bool(5==5);
    println_bool(5==2);

    println_bool(5!=5);
    println_bool(5!=2);

    println_bool(3<=3);
    println_bool(3<=4);
    println_bool(3<=2);

    println_bool(3>=3);
    println_bool(3>=4);
    println_bool(3>=2);

    println_bool(3<3);
    println_bool(3<4);
    println_bool(3<2);

    println_bool(3>3);
    println_bool(3>4);
    println_bool(3>2);
    return 0;
}

// EXPECTED
// 1
// 0
// 0
// 1
// 1
// 1
// 0
// 1
// 0
// 1
// 0
// 1
// 0
// 0
// 0
// 1
