#include <stdio.h>
#include <string.h>

#define MAX 100      // Số chuỗi tối đa
#define MAX_LEN 100  // Độ dài tối đa của mỗi chuỗi

int main() {
    char chuoi[MAX][MAX_LEN];
    int n;

    // Bước 2: Nhập số lượng chuỗi
    printf("Nhap so luong chuoi: ");
    scanf("%d", &n);
    getchar(); // Xóa ký tự newline sau scanf

    // Bước 3: Nhập các chuỗi
    for (int i = 0; i < n; i++) {
        printf("Nhap chuoi thu %d: ", i + 1);
        fgets(chuoi[i], MAX_LEN, stdin);
        // Xóa ký tự '\n' nếu có
        chuoi[i][strcspn(chuoi[i], "\n")] = '\0';
    }

    // Bước 4: Sắp xếp chuỗi bằng thuật toán nổi bọt
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (strcmp(chuoi[j], chuoi[j + 1]) > 0) {
                char temp[MAX_LEN];
                strcpy(temp, chuoi[j]);
                strcpy(chuoi[j], chuoi[j + 1]);
                strcpy(chuoi[j + 1], temp);
            }
        }
    }

    // Bước 5: In ra danh sách đã sắp xếp
    printf("\nDanh sach chuoi sau khi sap xep:\n");
    for (int i = 0; i < n; i++) {
        printf("%s\n", chuoi[i]);
    }

    return 0;
}
