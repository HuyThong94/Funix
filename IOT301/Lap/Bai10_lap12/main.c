#include <stdio.h>
#include <string.h>

// Khai báo prototype
char *multi_tok(char *input, char *delimiter);
void JsonExtract(char hoten[], char gioitinh[], char sdt[], char email[], char input[]);

int main() {
    // JSON đầu vào
    char json[] = "[{\"hoten\":\"Le Thi My Duyen\",\"gioitinh\":\"nu\",\"sodienthoai\":\"0935777888\",\"email\":\"duyen86@gmail.com\"},"
                  "{\"hoten\":\"Tran Trung Thanh\",\"gioitinh\":\"nam\",\"sodienthoai\":\"976333444\",\"email\":\"thanhtt95@gmail.com\"},"
                  "{\"hoten\":\"Huynh Anh Hoang\",\"gioitinh\":\"nu\",\"sodienthoai\":\"0939745220\",\"email\":\"hahoang88@gmail.com\"},"
                  "{\"hoten\":\"Nguyen Minh Khoi\",\"gioitinh\":\"nam\",\"sodienthoai\":\"0703666777\",\"email\":\"khoimaster@gmail.com\"}]";

    char hoten[100], gioitinh[100], sdt[100], email[100];
    char khachhang[500];
    char hoten_nam[10][100];
    int sl_nam = 0, sl_khachhang = 0, i = 0;

    char *token = multi_tok(json, "},{");

    while (token != NULL) {
        strcpy(khachhang, token);

        // Thêm dấu ngoặc nếu là phần tử đầu hoặc cuối
        if (token[0] != '{') {
            char temp[500] = "{";
            strcat(temp, token);
            strcpy(khachhang, temp);
        }
        if (token[strlen(token) - 1] != '}') {
            strcat(khachhang, "}");
        }

        JsonExtract(hoten, gioitinh, sdt, email, khachhang);

        if (strcmp(gioitinh, "nam") == 0) {
            strcpy(hoten_nam[sl_nam], hoten);
            sl_nam++;
        }

        sl_khachhang++;
        token = multi_tok(NULL, "},{");
    }

    printf("Co tong cong %d khach hang nam / tong so %d khach hang\n", sl_nam, sl_khachhang);
    if (sl_nam > 0) {
        printf("Ho ten cac khach hang nam:\n");
        for (i = 0; i < sl_nam; i++) {
            printf("%d. %s\n", i + 1, hoten_nam[i]);
        }
    }

    return 0;
}
void JsonExtract(char hoten[], char gioitinh[], char sdt[], char email[], char input[]) {
    sscanf(input,
           "{\"hoten\":\"%[^\"]\",\"gioitinh\":\"%[^\"]\",\"sodienthoai\":\"%[^\"]\",\"email\":\"%[^\"]\"}",
           hoten, gioitinh, sdt, email);
}
char *multi_tok(char *input, char *delimiter) {
    static char *string;
    if (input != NULL)
        string = input;

    if (string == NULL)
        return NULL;

    char *end = strstr(string, delimiter);
    if (end == NULL) {
        char *temp = string;
        string = NULL;
        return temp;
    }

    char *temp = string;
    *end = '\0';
    string = end + strlen(delimiter);
    return temp;
}
