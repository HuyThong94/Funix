#include <stdio.h>

int main() {
    // Bước 1: Khai báo 2 mảng với số lượng phần tử khác nhau
    int arr1[6] = {1, 2, 3, 4, 5, 6};
    int arr2[3] = {10, 20, 30};

    // Bước 2: Khai báo con trỏ và biến trung gian
    int *ptr1 = arr1;
    int *ptr2 = arr2;
    int temp;
    int i;

    // Hiển thị trước khi hoán đổi
    printf("Truoc khi hoan doi:\n");
    printf("Mang 1: ");
    for (i = 0; i < 6; i++) {
        printf("%d ", arr1[i]);
    }
    printf("\nMang 2: ");
    for (i = 0; i < 3; i++) {
        printf("%d ", arr2[i]);
    }

    // Bước 3: Hoán đổi phần tử đầu tiên của 3 phần tử
    for (i = 0; i < 3; i++) {
        temp = *(ptr2 + i);
        *(ptr2 + i) = *(ptr1 + i);
        *(ptr1 + i) = temp;
    }

    // Bước 4: Hiển thị kết quả sau khi hoán đổi
    printf("\n\nSau khi hoan doi:\n");
    printf("Mang 1: ");
    for (i = 0; i < 6; i++) {
        printf("%d ", arr1[i]);
    }
    printf("\nMang 2: ");
    for (i = 0; i < 3; i++) {
        printf("%d ", arr2[i]);
    }

    return 0;
}
