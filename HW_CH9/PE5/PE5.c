#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define N 100
#define REPEATS 50

// Fills the n x n matrix with random integers between 1 and 100
void fill_random(int n, int arr[n][n]) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            arr[i][j] = rand() % 100 + 1; // Random integers between 1 and 100
        }
    }
}

// Function to perform matrix multiplication
void matmul(int n, int a[n][n], int b[n][n], int result[n][n]) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            result[i][j] = 0;
            for (int k = 0; k < n; k++) {
                result[i][j] += a[i][k] * b[k][j];
            }
        }
    }
}

// Creates two sets of NxN matrices (three static three stack-dynamic), fills with data, and performs multiplication, measuring time taken
void run_test(void) {
    static int sA[N][N];
    static int sB[N][N];
    static int sC[N][N];

    int n = N;
    int dA[N][N];
    int dB[N][N];
    int dC[N][N];

    fill_random(n, sA);
    fill_random(n, sB); 
    fill_random(n, dA);
    fill_random(n, dB);

    clock_t start, end;
    double static_time, dynamic_time;

    start = clock();
    for (int r = 0; r < REPEATS; r++) {
        matmul(n, sA, sB, sC);
    }
    end = clock();
    static_time = ((double) (end - start)) / CLOCKS_PER_SEC;

    start = clock();
    for (int r = 0; r < REPEATS; r++) {
        matmul(n, dA, dB, dC);
    }
    end = clock();
    dynamic_time = ((double) (end - start)) / CLOCKS_PER_SEC;

    printf("Matrix size: %dx%d, Repeats: %d\n", N, N, REPEATS);
    printf("Static matrix multiplication time: %f seconds\n", static_time);
    printf("Dynamic matrix multiplication time: %f seconds\n", dynamic_time);
}

int main(void) {
    srand((unsigned int)time(NULL)); // Seed for random number generation
    run_test();
    return 0;
}