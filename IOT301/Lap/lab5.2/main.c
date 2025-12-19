#include <stdio.h>
#include <stdlib.h>

int main()
{
    int num;

    printf("Nhap mot so nguyen: ");
    scanf("%d", &num);

    num = num | (1 << 4);

    printf("So sau khi dat bit 5 thanh 1 la: %d\n", num);

    return 0;
}
