#include "printlib.h"

int main() {
        int i, j;
        for (i=0; i<3; i=i+1) {
            for (j=0; j<3; j=j+1) {
                println_int(i*3+j);
            }
        }
        return 0;
}

// EXPECTED
// 0
// 1
// 2
// 3
// 4
// 5
// 6
// 7
// 8

