#include "printlib.h"

int main() {
        int i,j,n;
        n = 4;
        i = 1;
        while (i<n+1){
            j = 1;
            while (j<n+1){
                println_int(i*j);
                j = j + 1;
            }
            i = i + 1;
        }
        return 0;
}

// EXPECTED
// 1
// 2
// 3
// 4
// 2
// 4
// 6
// 8
// 3
// 6
// 9
// 12
// 4
// 8
// 12
// 16
