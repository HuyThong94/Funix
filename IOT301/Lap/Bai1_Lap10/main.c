#include <stdio.h>
#include <stdbool.h>

// Hàm tính độ dài chuỗi
int tinhDoDaiChuoi(const char *chuoi) {
    int doDai = 0;
    while (chuoi[doDai] != '\0') {
        doDai++;
    }
    return doDai;
}

// Hàm nối hai chuỗi
void noiChuoi(char *ketQua, const char *chuoi1, const char *chuoi2) {
    int i = 0;

    // Gán chuỗi thứ nhất vào ketQua
    for (; chuoi1[i] != '\0'; i++) {
        ketQua[i] = chuoi1[i];
    }

    // Gán chuỗi thứ hai tiếp nối
    int j = 0;
    while (chuoi2[j] != '\0') {
        ketQua[i] = chuoi2[j];
        i++;
        j++;
    }

    // Thêm ký tự kết thúc chuỗi
    ketQua[i] = '\0';
}

// Hàm kiểm tra hai chuỗi có giống nhau không
bool kiemTraChuoi(const char *chuoi1, const char *chuoi2) {
    int i = 0;
    while (chuoi1[i] != '\0' && chuoi2[i] != '\0') {
        if (chuoi1[i] != chuoi2[i]) {
            return false;
        }
        i++;
    }

    // Kiểm tra cả hai đều kết thúc cùng lúc
    return (chuoi1[i] == '\0' && chuoi2[i] == '\0');
}

// Hàm main để kiểm tra
int main() {
    char chuoi1[] = "Hello";
    char chuoi2[] = "World";
    char ketQua[100]; // đủ lớn để chứa chuỗi kết quả

    // Kiểm tra độ dài
    printf("Độ dài chuỗi 1: %d\n", tinhDoDaiChuoi(chuoi1));
    printf("Độ dài chuỗi 2: %d\n", tinhDoDaiChuoi(chuoi2));

    // Nối chuỗi
    noiChuoi(ketQua, chuoi1, chuoi2);
    printf("Chuỗi sau khi nối: %s\n", ketQua);

    // Kiểm tra chuỗi
    bool giongNhau = kiemTraChuoi(chuoi1, chuoi2);
    if (giongNhau) {
        printf("Hai chuỗi giống nhau.\n");
    } else {
        printf("Hai chuỗi khác nhau.\n");
    }

    return 0;
}
