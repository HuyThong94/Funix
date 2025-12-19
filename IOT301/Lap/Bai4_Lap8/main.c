#include <stdio.h>
#include <stdlib.h>

#define YEARS 5    // Số năm dữ liệu
#define MONTHS 12  // Số tháng trong năm

int main() {
    // Bước 1: Khai báo mảng lưu lượng mưa theo từng tháng trong 5 năm
    float rain[YEARS][MONTHS] = {
        {4.3, 4.3, 4.3, 3.0, 2.0, 1.2, 0.2, 0.2, 0.4, 2.4, 3.5, 6.6},
        {8.5, 8.2, 1.2, 1.6, 2.4, 0.0, 5.2, 0.9, 0.3, 1.4, 7.3, 9.1},
        {9.1, 8.5, 6.7, 4.3, 2.1, 0.8, 0.2, 0.2, 1.1, 2.3, 6.1, 8.4},
        {7.2, 9.9, 8.4, 3.3, 1.2, 0.8, 0.4, 0.6, 1.7, 3.4, 3.6, 6.2},
        {6.7, 5.8, 3.8, 3.2, 3.8, 0.0, 0.0, 0.0, 0.0, 1.3, 2.6, 5.2}
    };

    float total = 0; // Tổng lượng mưa cho tất cả các năm
    int year, month;

    // Bước 2: Hiển thị lượng mưa theo từng năm
    printf("Nam\tTong luong mua (inches)\n");
    for (year = 0; year < YEARS; year++) {
        float subtot = 0; // Tổng lượng mưa trong một năm
        for (month = 0; month < MONTHS; month++) {
            subtot += rain[year][month];
        }
        printf("%d\t%15.1f\n", 2010 + year, subtot);
        total += subtot;
    }

    // Hiển thị tổng lượng mưa trong 5 năm và trung bình mỗi năm
    printf("\nTong luong mua trong %d nam: %.1f inches\n", YEARS, total);
    printf("Luong mua trung binh moi nam: %.1f inches\n\n", total / YEARS);

    // Bước 3: Hiển thị lượng mưa trung bình theo từng tháng
    printf("Luong mua trung binh theo thang:\n");
    for (month = 0; month < MONTHS; month++) {
        float subtot = 0; // Tổng lượng mưa của một tháng trong nhiều năm
        for (year = 0; year < YEARS; year++) {
            subtot += rain[year][month];
        }
        printf("%4.1f ", subtot / YEARS); // Hiển thị trung bình của tháng
    }

    printf("\n");
    return 0;
}
