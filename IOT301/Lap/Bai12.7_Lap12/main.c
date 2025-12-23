#include <stdio.h>

// Hàm hoán đổi hai số nguyên dùng con trỏ
void swap(int *x, int *y)
{
    int temp = *x;
    *x = *y;
    *y = temp;
}

int main()
{
    // Khai báo và khởi tạo giá trị hai biến
    int a = 5, b = 10;

    // Hiển thị giá trị trước khi hoán đổi
    printf("Truoc khi hoan doi: a = %d, b = %d\n", a, b);

    // Gọi hàm hoán đổi
    swap(&a, &b);

    // Hiển thị giá trị sau khi hoán đổi
    printf("Sau khi hoan doi: a = %d, b = %d\n", a, b);

    return 0;
}
