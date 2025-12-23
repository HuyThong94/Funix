#include <stdio.h>
#include <stdlib.h>

int main()
{
    unsigned int id, soGioLam, luongMoiGio, tienLuong;
    printf("Nhap ID nhan vien: ");
    scanf("%d", &id);
    printf("Nhap so gio lam trong 1 thang: ");
    scanf("%d", &soGioLam);
    printf("Nhap luong moi gio lam: ");
    scanf("%d", &luongMoiGio);
    tienLuong = soGioLam * luongMoiGio;
    printf("ID nhan vien: %d\n", id);
    printf("So tien luong nhan duoc cua 1 thang: %d", tienLuong);
}
