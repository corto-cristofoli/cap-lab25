#include "printlib.h"


int main() {
    int x,y;
    if (x==y) {
        if (x!=y) {
            println_int(9);
        } else {
            println_int(18);
        }
    } else {
        println_int(27);
    }
    return 0;
}

// EXPECTED
// 18
