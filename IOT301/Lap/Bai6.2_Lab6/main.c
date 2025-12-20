#include <stdio.h>
#include <stdlib.h>

int main()
{
    int soNguyen;
    printf("Nhap so nguyen:");
    scanf("%d", &soNguyen);
    if(soNguyen % 2 == 0){
        printf("So nguyen %d la so chan", soNguyen);
    }else{
        printf("So nguyen %d la so le", soNguyen);
    }
    return 0;
}
