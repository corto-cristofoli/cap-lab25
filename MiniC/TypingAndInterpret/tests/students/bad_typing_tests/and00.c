#include "printlib.h"

int main() {
    int a;
    bool b;
    b = true;
    
    println_bool(b && a);
    return 0;
}
// EXPECTED
// EXITCODE 2
// In function main: Line 8 col 17: invalid type for and operator: integer
