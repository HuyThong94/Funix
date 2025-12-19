#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 100  // Kích thước tối đa của mảng

// Hàm hoán vị hai số
void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

// Hàm sắp xếp giảm dần (Selection Sort)
void sortDescending(int arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            if (arr[i] < arr[j]) {
                swap(&arr[i], &arr[j]);
            }
        }
    }
}

// Hàm sắp xếp tăng dần (Selection Sort)
void sortAscending(int arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            if (arr[i] > arr[j]) {
                swap(&arr[i], &arr[j]);
            }
        }
    }
}

// Hàm hiển thị mảng
void printArray(int arr[], int n) {
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

int main() {
    int arr[MAX_SIZE], n;

    // Bước 2: Nhập số phần tử của mảng (đảm bảo n > 0)
    do {
        printf("Nhap so luong phan tu (1-100): ");
        scanf("%d", &n);
    } while (n <= 0 || n > MAX_SIZE);

    // Bước 3: Nhập các phần tử của mảng
    printf("Nhap %d phan tu:\n", n);
    for (int i = 0; i < n; i++) {
        printf("arr[%d] = ", i);
        scanf("%d", &arr[i]);
    }

    // Bước 4: Sắp xếp và hiển thị theo thứ tự giảm dần
    sortDescending(arr, n);
    printf("\nMang sau khi sap xep giam dan:\n");
    printArray(arr, n);

    // Bước 6: Sắp xếp và hiển thị theo thứ tự tăng dần
    sortAscending(arr, n);
    printf("\nMang sau khi sap xep tang dan:\n");
    printArray(arr, n);

    return 0;
}
