#include <stdio.h>
#include <stdlib.h>

int main()
{
    float chieuDai, chieuRong, chuVi, dienTich;

    printf("Nhap chieu dai: ");
    scanf("%f", &chieuDai);
    printf("Nhap chieu rong: ");
    scanf("%f", &chieuRong);

    chuVi = 2 * (chieuDai + chieuRong);
    dienTich = chieuDai * chieuRong;

    printf("Chu vi cua hinh chu nhat co chieu dai %.2f va chieu rong %.2f la %.2f\n", chieuDai, chieuRong, chuVi);
    printf("Dien tich cua hinh chu nhat co chieu dai %.2f va chieu rong %.2f la %.2f\n", chieuDai, chieuRong, dienTich);

    return 0;
}
