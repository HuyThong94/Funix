#include <stdio.h>
#include <string.h>

// Hàm trích xuất thông tin từ chuỗi JSON
void JsonExtract(char json[], char hoten[], char gioitinh[], char sodienthoai[], char email[]) {
    char info[4][100];
    int i = 0;

    // Cắt từng phần tử theo dấu ',' và lưu vào mảng info
    char* token = strtok(json, ",");
    while (token != NULL) {
        strcpy(info[i], token);
        i++;
        token = strtok(NULL, ",");
    }

    // Trích xuất họ tên
    char* hoten_token = strtok(info[0], ":");
    strcpy(hoten, strtok(NULL, ":"));

    // Trích xuất giới tính
    strtok(info[1], ":");
    strcpy(gioitinh, strtok(NULL, ":"));

    // Trích xuất số điện thoại
    strtok(info[2], ":");
    strcpy(sodienthoai, strtok(NULL, ":"));

    // Trích xuất email
    strtok(info[3], ":");
    strcpy(email, strtok(NULL, ":"));

    // Xoá dấu ngoặc nhọn hoặc dấu " nếu có ở cuối email
    if (email[strlen(email) - 1] == '}')
        email[strlen(email) - 1] = '\0';
    if (email[strlen(email) - 1] == '"')
        email[strlen(email) - 1] = '\0';

    // Xoá dấu " nếu có ở đầu các chuỗi
    if (hoten[0] == '"') memmove(hoten, hoten + 1, strlen(hoten));
    if (gioitinh[0] == '"') memmove(gioitinh, gioitinh + 1, strlen(gioitinh));
    if (sodienthoai[0] == '"') memmove(sodienthoai, sodienthoai + 1, strlen(sodienthoai));
    if (email[0] == '"') memmove(email, email + 1, strlen(email));
}

// Hàm main
int main() {
    char json[] = "{\"hoten\":\"Le Thi My Duyen\",\"gioitinh\":\"nu\",\"sodienthoai\":\"0935777888\",\"email\":\"duyen86@gmail.com\"}";
    char hoten[100], gioitinh[100], sodienthoai[100], email[100];

    JsonExtract(json, hoten, gioitinh, sodienthoai, email);

    // Hiển thị kết quả
    printf("Thong tin cua doi tuong JSON:\n");
    printf("Ho ten     : %s\n", hoten);
    printf("Gioi tinh  : %s\n", gioitinh);
    printf("Dien thoai : %s\n", sodienthoai);
    printf("Email      : %s\n", email);

    return 0;
}
