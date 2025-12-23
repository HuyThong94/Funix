#include <stdio.h>
#include <stdlib.h>

int main()
{
    int soThuNhat, soThuHai, soThuBa, soThuTu;
    printf("Nhap so thu nhat: ");
    scanf("%d", &soThuNhat);
    printf("Nhap so thu hai: ");
    scanf("%d", &soThuHai);
    printf("Nhap so thu ba: ");
    scanf("%d", &soThuBa);
    printf("Nhap so thu Tu: ");
    scanf("%d", &soThuTu);
    printf("Binh phuong cua so thu nhat %d la: %d\n", soThuNhat, soThuNhat * soThuNhat);
    printf("Binh phuong cua so thu hai %d la: %d\n", soThuHai, soThuHai * soThuHai);
    printf("Binh phuong cua so thu ba %d la: %d\n", soThuBa, soThuBa * soThuBa);
    printf("Binh phuong cua so thu tu %d la: %d\n", soThuTu, soThuTu * soThuTu);
    return 0;
}
