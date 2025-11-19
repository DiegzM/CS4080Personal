#include <iostream>

using namespace std;

template <typename T>

int findElement(T arr[], int size, T value) {
    for (int i = 0; i < size; i++) {
        if (arr[i] == value) {
            return i; // Return the subscript if found
        }
    }
    return -1; // Return -1 if not found
}

int main() {

    // Test with int array
    int intArr[] = {10, 20, 30, 40, 50};
    int intSize = sizeof(intArr) / sizeof(intArr[0]);
    int intValue = 30;

    int intResult = findElement(intArr, intSize, intValue);
    cout << "Searching for " << intValue << " in int array:";
    cout << (intResult != -1 ? " Found at index " + to_string(intResult) : " Not found") << endl;

    // Test with float arr
    float floatArr[] = {1.1f, 2.2f, 3.3f, 4.4f, 5.5f};
    int floatSize = sizeof(floatArr) / sizeof(floatArr[0]);
    float floatValue = 4.4f;

    int floatResult = findElement(floatArr, floatSize, floatValue);
    cout << "Searching for " << floatValue << " in float array:";
    cout << (floatResult != -1 ? " Found at index " + to_string(floatResult) : " Not found") << endl;

    return 0;
}