#include "printlib.h"


int main() {
        bool a, b, c;
        println_bool((a&&(b||c))==((a&&b)||(a&&c))); // Distributive propriety
        println_bool(!(b&&c)==(!b)||(!c)); // De Morgan
        return 0;
}

// EXPECTED
// 1
// 1
