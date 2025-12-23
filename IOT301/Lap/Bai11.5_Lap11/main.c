#include <stdio.h>

int main() {
    // Bước 1: Khai báo biến và con trỏ
    int num1 = 31;
    int num2 = 45;

    int *pnum1 = &num1;
    int *pnum2 = &num2;

    // Bước 2: Hoán đổi giá trị bằng con trỏ
    int temp = *pnum1;
    *pnum1 = *pnum2;
    *pnum2 = temp;

    // Bước 3: Hiển thị kết quả sau khi hoán đổi
    printf("Sau khi hoan doi:\n");
    printf("num1 = %d\n", *pnum1);
    printf("num2 = %d\n", *pnum2);

    return 0;
}
