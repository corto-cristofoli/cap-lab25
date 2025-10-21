#include "printlib.h"

int main() {
        println_float(1.0/(4.0-2.0*2.0));
        return 0;
}

// SKIP TEST EXPECTED
// EXPECTED
// EXITCODE 5
// Unsupported type float
