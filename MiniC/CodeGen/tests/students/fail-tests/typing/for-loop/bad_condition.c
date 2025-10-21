#include "printlib.h"


int main() {
        int i;
        for (i=0; i+5; i=i+1){
            println_int(i);
        }
        return 0;
}

// SKIP TEST EXPECTED
// EXPECTED
// EXITCODE 2
// In function main: Line 6 col 8: invalid type for condition statement: integer
