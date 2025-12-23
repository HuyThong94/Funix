#include <stdio.h>

// Bước 2: Định nghĩa hàm cộng 2 số bằng con trỏ
int add(int *pnum1, int *pnum2)
{
    return (*pnum1 + *pnum2);
}

int main()
{
    // Bước 1: Khai báo và khởi tạo 3 biến
    int a = 10;
    int b = 20;
    int sum;

    // Bước 2: Gọi hàm add để tính tổng
    sum = add(&a, &b);

    // Bước 3: Hiển thị kết quả
    printf("Tong cua %d va %d la: %d\n", a, b, sum);

    return 0;
}
