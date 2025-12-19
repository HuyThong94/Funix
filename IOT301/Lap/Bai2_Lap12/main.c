#include <stdio.h>
#include <stdbool.h>

bool compare(const char s1[], const char s2[]) {
    int i = 0;
    char *ptr1 = s1;
    char *ptr2 = s2;
    bool isEquals = false;

    // So sánh từng ký tự cho đến khi gặp ký tự kết thúc '\0'
    while (*(ptr1 + i) == *(ptr2 + i) &&
           *(ptr1 + i) != '\0' &&
           *(ptr2 + i) != '\0') {
        i++;
    }

    // Nếu cả hai cùng kết thúc tại '\0', tức là giống nhau
    if (*(ptr1 + i) == '\0' && *(ptr2 + i) == '\0') {
        isEquals = true;
    } else {
        isEquals = false;
    }

    return isEquals;
}

int main() {
    printf("\n%d\n", compare("hoang", "hoang"));  // In ra 1 nếu giống, 0 nếu khác
    return 0;
}
