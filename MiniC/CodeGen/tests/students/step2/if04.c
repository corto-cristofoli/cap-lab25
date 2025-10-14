#include "printlib.h"

int main() {
    if (3+4<7){
        println_int(5);
    } else {
        println_int(3);
    }
    return 0;
}

// EXPECTED
// 3
