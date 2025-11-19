#include <stdio.h>

int x;

int subprogram(int *param) {
    printf("(in subprogram) Address of param: %p, Value of param: %d\n", (void*)param, *param);

    *param = *param + 10;
    x += 5;
    *param = *param + x;

    printf("(in subprogram) Address of param: %p, Final value of param: %d\n", (void*)param, *param);
    return *param;
}

int main() {
    x = 5;

    printf("Before call: x = %d\n", x);

    // Pass by value-result
    int temp = x;
    temp = subprogram(&temp);
    x = temp;

    printf("After call (value-result): x = %d\n", x);

    x = 5;
    printf("Before call: x = %d\n", x);

    // Pass by reference
    temp = subprogram(&x);
    printf("After call (reference): x = %d\n", x);
    return 0;
}