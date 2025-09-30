#include "printlib.h"

int main() {
    float a,b,c;
    int k,n;
    a = 3.2;
    b = 1.1;
    c = a*b;
    
    k = -5;
    n = 3;
    
    println_float(c);
    println_int(k / n);
    println_int(k % n);
    println_int( (k/n)*n + k%n );
    return 0;
}

// EXPECTED
// 3.52
// -1
// -2
// -5
