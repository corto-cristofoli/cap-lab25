#include "printlib.h"

int main() {
        int i;
        for (i=0; i<5; i=i+1){
            println_int(i);
        }
        return 0;
}

// EXPECTED
// 0
// 1
// 2
// 3
// 4
