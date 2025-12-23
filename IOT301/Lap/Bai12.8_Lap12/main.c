#include <stdio.h>

// Hàm tính giai thừa
void findFact(int n, int *f)
{
    int i;
    *f = 1; // Khởi tạo giá trị ban đầu

    for (i = 1; i <= n; i++)
    {
        *f = *f * i;
    }
}

int main()
{
    int num, factorial;

    // Nhập số từ người dùng
    printf("Nhap mot so: ");
    scanf("%d", &num);

    // Gọi hàm tính giai thừa
    findFact(num, &factorial);

    // Hiển thị kết quả
    printf("Giai thua cua %d la: %d\n", num, factorial);

    return 0;
}
