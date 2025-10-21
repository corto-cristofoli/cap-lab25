#include "printlib.h"


int main() {
        int x;
        bool b;
        println_bool(x==x);
        println_bool(b==b);
        println_bool(1==0);
        println_bool(1==1);
        println_bool((1+2)==3);
        println_bool(false==true);
        println_bool(true==true);
        println_bool((false||true)==true);
        return 0;
}

// EXPECTED
// 1
// 1
// 0
// 1
// 1
// 0
// 1
// 1
