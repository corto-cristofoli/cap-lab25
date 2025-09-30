#include "printlib.h"

int main() {
    int a;
    float b;
    
    println_bool(b < a);
    return 0;
}
// EXPECTED
// EXITCODE 2
// In function main: Line 7 col 17: type mismatch for relational operands: float and integer
