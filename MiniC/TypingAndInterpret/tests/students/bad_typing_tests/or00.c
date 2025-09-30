#include "printlib.h"

int main() {
    int a;
    bool b;
    b = true;
    
    println_bool(b || a);
    return 0;
}
// EXITCODE 2
// EXPECTED
// In function main: Line 8 col 17: invalid type for or operator: integer
