#include <stdio.h>

int main() {
    char str[100];
    int i, j;

    // Bước 2: Nhập chuỗi
    printf("Nhap chuoi: ");
    scanf("%s", str);

    // Bước 3: Loại bỏ các ký tự không phải chữ cái hoặc chữ số
    for (i = 0; str[i] != '\0'; ++i) {
        while (!((str[i] >= 'a' && str[i] <= 'z') ||
                 (str[i] >= 'A' && str[i] <= 'Z') ||
                 (str[i] >= '0' && str[i] <= '9')) &&
                 (str[i] != '\0')) {
            for (j = i; str[j] != '\0'; ++j) {
                str[j] = str[j + 1];  // Dịch trái chuỗi
            }
        }
    }

    // Bước 4: In kết quả
    printf("Chuoi sau khi loai bo ky tu khong hop le: %s\n", str);

    return 0;
}
