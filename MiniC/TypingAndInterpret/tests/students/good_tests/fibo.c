#include "printlib.h"

int main() {
    int cpt;
    int fibo1, fibo2;
    int a;
    fibo1 = 1;

    while (cpt < 10){
        a = fibo1;
        fibo1 = fibo1 + fibo2;
        fibo2 = a;
        println_int(fibo1);
        cpt = cpt + 1;
    }
    return 0;
}

// EXPECTED
// 1
// 2
// 3
// 5
// 8
// 13
// 21
// 34
// 55
// 89
