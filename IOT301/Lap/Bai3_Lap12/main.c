#include <stdio.h>

int main() {
    int n, i;

    // Bước 1: Khai báo mảng và con trỏ
    int arr[100];  // Giả sử mảng tối đa 100 phần tử
    int *ptr = arr;

    // Bước 2: Nhập số lượng phần tử
    printf("Nhap so luong phan tu: ");
    scanf("%d", &n);

    // Nhập các phần tử của mảng
    for(i = 0; i < n; i++) {
        printf("Nhap phan tu thu %d: ", i + 1);
        scanf("%d", (ptr + i));
    }

    // Bước 3: Khởi tạo biến max là phần tử đầu tiên
    int max = *ptr;

    // Bước 4: Dùng vòng lặp để tìm số lớn nhất
    for(i = 1; i < n; i++) {
        if(*(ptr + i) > max) {
            max = *(ptr + i);
        }
    }

    // Bước 5: In ra kết quả
    printf("So lon nhat trong mang la: %d\n", max);

    return 0;
}
