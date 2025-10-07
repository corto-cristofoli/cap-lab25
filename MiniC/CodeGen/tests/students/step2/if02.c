#include "printlib.h"

int main() {
    if (true){
        println_int(5);
    }
    if (false){
        println_int(3)
    }
    return 0;
}

// EXPECTED
// 5
