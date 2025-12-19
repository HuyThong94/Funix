#include <stdio.h>

int main() {
    // Bước 1: Khai báo biến cơ bản
    char x = 0;
    int y = 1;
    float z = 3.0;

    // Bước 2: Khai báo con trỏ trỏ tới các biến trên
    char *px = &x;
    int *py = &y;
    float *pz = &z;

    // Gán giá trị mới thông qua con trỏ
    *px = 12;
    *py = 23;
    *pz = 2323.42;

    // Bước 3: In địa chỉ con trỏ, địa chỉ biến và giá trị
    printf("Dia chi cua px la %p, dia chi va gia tri cua bien x la %p, %d\n", (void*)px, (void*)&x, *px);
    printf("Dia chi cua py la %p, dia chi va gia tri cua bien y la %p, %d\n", (void*)py, (void*)&y, *py);
    printf("Dia chi cua pz la %p, dia chi va gia tri cua bien z la %p, %.2f\n", (void*)pz, (void*)&z, *pz);

    return 0;
}
