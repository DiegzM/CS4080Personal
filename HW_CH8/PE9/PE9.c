#include <stdio.h>

int main() {
    int x = 0;
    int y = 0;
    if (x>10) {
        y = x;
    }
    else if (x<5) {
        y = 2*x;
    }
    else if (x==7) {
        y = x+10;
    }
    printf("Program executed successfully!");
}