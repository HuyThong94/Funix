#include <stdio.h>
#include <stdlib.h>

int main()
{
    int day, week, year;
    printf("Nhap so ngay: ");
    scanf("%d", &day);
    year = day/365;
    week = (day-year*365)/7;
    day = day-year*365-week*7;
    printf("so nam: %d\n", year);
    printf("so tuan: %d\n", week);
    printf("so ngay: %d\n", day);
    return 0;
}
