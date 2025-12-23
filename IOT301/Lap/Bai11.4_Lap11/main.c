#include <stdio.h>

int main() {
    // Bước 1: Khai báo biến và con trỏ
    int num1 = 0, num2 = 0;
    int *pnum1 = &num1;
    int *pnum2 = &num2;

    // Bước 2: Nhập giá trị và tính tổng qua con trỏ
    printf("Nhap so thu nhat: ");
    scanf("%d", pnum1);

    printf("Nhap so thu hai: ");
    scanf("%d", pnum2);

    printf("Tong cua hai so %d va %d la %d\n", *pnum1, *pnum2, (*pnum1 + *pnum2));

    return 0;
}
