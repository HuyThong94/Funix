#include <stdio.h>
#include <stdlib.h>

int main()
{
    int minute, day, year;
    printf("Nhap so phut: ");
    scanf("%d", & minute);

    day = minute %(60 * 24) == 0 ? minute /(60*24): minute /(60 * 24)+ 1;
    year = day%365 == 0? day / 365: day / 365 + 1;
    printf("so nam: %d\n", year);
    printf("so ngay: %d\n", day);
    return 0;
}
