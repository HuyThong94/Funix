#include <stdio.h>

int main() {
    // Bước 1: Khai báo và gán giá trị ban đầu
    int a = 51;

    // Bước 2: Khai báo con trỏ trỏ tới biến a
    int *ptr = &a;

    // Bước 3: Thay đổi giá trị thông qua con trỏ
    *ptr = 99;

    // Bước 4: In kết quả để kiểm tra
    printf("Gia tri cua bien a sau khi thay doi la: %d\n", a);

    return 0;
}
