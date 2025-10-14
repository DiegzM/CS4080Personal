#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define ARRAY_SIZE 10000
#define ITERATIONS 1000000

// Function 1: Static array (declared once, exists for entire program)
void static_array() {
    static int arr[ARRAY_SIZE];
}

// Function 2: Stack array (created each time function is called)
void stack_array() {
    int arr[ARRAY_SIZE];
}

// Function 3: Heap array (allocated dynamically)
void heap_array() {
    int *arr = (int*)malloc(ARRAY_SIZE * sizeof(int));
    free(arr);
}

int main() {
    clock_t start, end;
    double time_taken;
    
    printf("Testing with array size: %d\n", ARRAY_SIZE);
    printf("Number of iterations: %d\n\n", ITERATIONS);
    

    // Testing static array
    start = clock();
    for (int i = 0; i < ITERATIONS; i++) {
        static_array();
    }
    end = clock();
    time_taken = ((double)(end - start)) / CLOCKS_PER_SEC;
    printf("Static array time: %.4f seconds\n", time_taken);
    

    // Testing stack array
    start = clock();
    for (int i = 0; i < ITERATIONS; i++) {
        stack_array();
    }
    end = clock();
    time_taken = ((double)(end - start)) / CLOCKS_PER_SEC;
    printf("Stack array time:  %.4f seconds\n", time_taken);
    

    // Testing heap array
    start = clock();
    for (int i = 0; i < ITERATIONS; i++) {
        heap_array();
    }
    end = clock();
    time_taken = ((double)(end - start)) / CLOCKS_PER_SEC;
    printf("Heap array time:   %.4f seconds\n", time_taken);
    
    return 0;
}
