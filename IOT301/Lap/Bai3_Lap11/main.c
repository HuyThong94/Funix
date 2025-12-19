#include <stdio.h>

int main() {
    // Bước 1: Khai báo biến và con trỏ
    int num1 = 0, num2 = 0;

    printf("Nhap so thu nhat: ");
    scanf("%d", &num1);

    printf("Nhap so thu hai: ");
    scanf("%d", &num2);

    int *pnum1 = &num1;
    int *pnum2 = &num2;

    // Bước 2: So sánh giá trị thông qua con trỏ
    if (*pnum1 > *pnum2) {
        printf("So %d lon hon so %d\n", *pnum1, *pnum2);
    } else if (*pnum1 < *pnum2) {
        printf("So %d nho hon so %d\n", *pnum1, *pnum2);
    } else {
        printf("Hai so bang nhau\n");
    }

    return 0;
}
