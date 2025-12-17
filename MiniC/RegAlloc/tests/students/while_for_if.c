#include "printlib.h"


int main() {
    int i,j;
    i = 0;   
    while (i<5){
        for (j=0; j<=i; j=j+1) {
            if (j<i) {
                println_int(j);
            } else {
                println_int(i);
            }
        }
        i = i+1;
    }
    return 0;
}

// EXPECTED
// 0
// 0
// 1
// 0
// 1
// 2
// 0
// 1
// 2
// 3
// 0
// 1
// 2
// 3
// 4
