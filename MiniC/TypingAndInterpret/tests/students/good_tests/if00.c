#include "printlib.h"

int main() {
    bool b;
    if (true) { println_string("Vrai"); }
    if (!b) {
        println_string("b est Faux");
    }
    if (b && true) {
        println_int(0);
    } else {
        println_int(1);
    }
    return 0;
}

// EXPECTED
// Vrai
// b est Faux
// 1
