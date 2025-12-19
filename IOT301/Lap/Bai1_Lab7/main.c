#include <stdio.h>
#include <stdlib.h>

int main()
{
    unsigned int number;
    printf("Nhap so tu nhien:");
    scanf("%d", &number);
    for(unsigned int i = 0; i <= number; i++){
        if(i % 2 == 0){
            printf("%d ", i);
        }
    }
    return 0;
}
