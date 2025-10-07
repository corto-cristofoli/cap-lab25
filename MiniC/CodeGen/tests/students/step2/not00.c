#include "printlib.h"

int main() {
    
    bool b;
    b = !b;
    println_bool(b);
    return 0;
}

// EXPECTED
// 1
