#include <stdio.h>

// Bước 3: Hàm tìm kiếm phần tử
void search(int *x, int *y) {
    int i, f = -1;

    for (i = 0; i < 5; i++) {
        if (*(x + i) == *y) {
            f = i;
            break;
        }
    }

    if (f != -1)
        printf("Da tim thay o vi tri %d.\n", f);
    else
        printf("Khong tim thay.\n");
}

int main() {
    int arr[5];
    int i, value;
    int *ptr = arr;      // Con trỏ trỏ đến mảng
    int *target = &value; // Con trỏ trỏ đến phần tử cần tìm

    // Bước 2: Nhập mảng và phần tử cần tìm
    printf("Nhap 5 phan tu cua mang:\n");
    for (i = 0; i < 5; i++) {
        printf("Phan tu thu %d: ", i + 1);
        scanf("%d", ptr + i);
    }

    printf("Nhap gia tri can tim: ");
    scanf("%d", target);

    // Gọi hàm tìm kiếm
    search(ptr, target);

    return 0;
}
