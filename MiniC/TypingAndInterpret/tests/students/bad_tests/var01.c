#include "printlib.h"

int main() {
    int x = 3;
    println_int(2 * x);

    return 0;
}
// EXPECTED
// EXITCODE 3
// line 4:10 mismatched input '=' expecting ';'
