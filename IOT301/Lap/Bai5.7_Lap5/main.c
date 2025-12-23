#include <stdio.h>
#include <stdlib.h>

int main()
{
    int soThuNhat, soThuHai, soThuBa, soThuTu, trungBinhCong;
    printf("Nhap so thu nhat: ");
    scanf("%d", &soThuNhat);
    printf("Nhap so thu hai: ");
    scanf("%d", &soThuHai);
    printf("Nhap so thu ba: ");
    scanf("%d", &soThuBa);
    printf("Nhap so thu Tu: ");
    scanf("%d", &soThuTu);
    trungBinhCong = (soThuNhat + soThuHai + soThuBa + soThuTu)/4;
    printf("Trung binh cong cua bon so %d, %d, %d, %d la: %d", soThuNhat, soThuHai, soThuBa, soThuTu, trungBinhCong);
    return 0;
}
