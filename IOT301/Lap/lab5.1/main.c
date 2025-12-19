#include <stdio.h>
#include <stdlib.h>

int main()
{
    int num;

    printf("Nhap 1 so nguyen: ");
    scanf("%d", &num);

    int bit3 = (num >> 2) & 1;

    printf("Bit thu 3 la bit %d\n", bit3);

    return 0;
}
