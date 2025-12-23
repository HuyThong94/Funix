#include <stdio.h>

int main() {
    char str[] = "Luong Huy Thong";
    char *ptr = str;
    int i = 0;

    // Bước 2: Tính độ dài chuỗi bằng con trỏ
    while (*(ptr + i) != '\0') {
        i++;
    }
    i--; // đưa i về vị trí ký tự cuối cùng

    // Bước 3: In chuỗi theo thứ tự ngược
    for (; i >= 0; i--) {
        printf("%c", *(ptr + i));
    }

    return 0;
}
