#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a = 65;
    int b = 0;
    printf("so can đoan là so co 2 chu so\n");
      do {
        printf("Nhập số: ");
        if (scanf("%d", &b) != 1) {  // Kiểm tra đầu vào có phải số không
            printf("Loi nhap. Vui long nhap so hop le\n");
            while (getchar() != '\n');  // Xóa bộ nhớ đệm để tránh lỗi lặp vô hạn
            continue;
        }

        if (b == a) {
            printf("Xin chuc mung, ban da doan dung!\n");
            return 0;  // Thoát chương trình ngay khi đoán đúng
        } else {
            printf("Ban da doan sai. Vui long nhap lai\n");
        }
    } while (a!=b);
    return 0;
}
