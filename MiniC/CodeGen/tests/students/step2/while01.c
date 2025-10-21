#include "printlib.h"


int main() {
        int fact, n, i;
        n = 10;
        fact = 1;
        i = 1;
        while (i<n+1){
            fact = fact * i;
            i=i+1;
        }
        println_int(fact);
        return 0;
}

// EXPECTED
// 3628800
