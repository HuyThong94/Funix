#include <stdio.h>
#include <stdlib.h>

int main()
{
    int nhietDo;
    printf("Nhap nhiet do:");
    scanf("%d", &nhietDo);
    if(nhietDo < 0){
        printf("Thoi tiet lanh cong");
    } else if(nhietDo > 0 && nhietDo < 10){
        printf("Thoi tiet rat lanh");
    } else if(nhietDo >= 10 && nhietDo < 20){
        printf("Thoi tiet lanh");
    } else if(nhietDo >=20 && nhietDo <= 30){
        printf("Thoi tiet nong");
    }else if(nhietDo > 40){
        printf("Thoi tiet rat nong");
    }
    return 0;
}
