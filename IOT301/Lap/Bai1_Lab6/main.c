#include <stdio.h>
#include <stdlib.h>

int main()
{
    float soThuNhat, soThuHai;
    printf("Nhap so thu nhat:");
    scanf("%f", &soThuNhat);
    printf("Nhap so thu hai:");
    scanf("%f", &soThuHai);
    if(soThuNhat == (int)soThuNhat && soThuHai == (int)soThuHai)
    {
        if(soThuNhat == soThuHai)
        {
            printf("So thu nhat bang so thu hai");
        }
        else if(soThuNhat > soThuHai)
        {
            printf("So thu nhat lon hon so thu hai");
        }
        else
        {
            printf("So thu nhat nho hon so thu hai");
        }
    }
    else
    {
        printf("So nhap vao khong phai so nguyen");
    }
    return 0;
}
