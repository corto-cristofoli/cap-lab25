#include "printlib.h"

int main() {
    bool a;
    bool b;
    
    println_bool(b <= a);
    return 0;
}
// EXPECTED
// EXITCODE 2
// In function main: Line 7 col 17: invalid type for relational operands: boolean
