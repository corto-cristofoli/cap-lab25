#include "printlib.h"

int main() {
    
    bool b;
    b=true;
    b=false||b;
    println_bool(b);
    return 0;
}

// EXPECTED
// 1
