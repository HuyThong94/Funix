#include <stdio.h>
#include <stdlib.h>

int main()
{
    int soThuNhat, soThuHai;
    printf("Nhap so thu nhat: ");
    scanf("%d", &soThuNhat);
    printf("Nhap so thu hai: ");
    scanf("%d", &soThuHai);
    if(soThuHai == 0){
    printf("So thu hai phai khac 0");
    }else{
    printf("Ket qua phep chia %d / %d =  %d\n",soThuNhat, soThuHai, (soThuNhat / soThuHai));
    printf("Phan du cua phep chia %d %% %d =  %d",soThuNhat, soThuHai, (soThuNhat % soThuHai));
    }
    return 0;
}
