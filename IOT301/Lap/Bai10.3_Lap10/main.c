#include <stdio.h>

int main() {
    char str[80], search[20];
    int c1 = 0, c2 = 0, i, j, flg = 1;

    // Bước 2: Nhập chuỗi
    printf("Nhap chuoi da cho: ");
    scanf("%s", str);
    printf("Nhap chuoi con: ");
    scanf("%s", search);

    // Bước 3: Đếm độ dài chuỗi
    while (str[c1] != '\0') {
        c1++;
    }

    while (search[c2] != '\0') {
        c2++;
    }

    // Bước 4: Kiểm tra chuỗi con có xuất hiện trong chuỗi đã cho không
    if (c1 >= c2) {
        for (i = 0; i <= c1 - c2; i++) {
            flg = 1;
            for (j = 0; j < c2; j++) {
                if (str[i + j] != search[j]) {
                    flg = 0;
                    break;
                }
            }
            if (flg == 1) {
                break;
            }
        }

        // Bước 5: Xuất kết quả
        if (flg == 1)
            printf("Chuoi con xuat hien trong chuoi da cho.\n");
        else
            printf("Chuoi con khong xuat hien trong chuoi da cho.\n");

    } else {
        printf("Khong xet truong hop chuoi con co kich thuoc lon hon chuoi da cho.\n");
    }

    return 0;
}
