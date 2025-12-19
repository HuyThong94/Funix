#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main() {
    // Bước 1: Khai báo mảng lưu các số nguyên tố và biến hỗ trợ
    unsigned int primes[100] = {0};  // Mảng lưu số nguyên tố
    unsigned int primeIndex = 2;     // Chỉ số của số nguyên tố trong mảng
    bool isPrime;                    // Biến kiểm tra số nguyên tố

    // Bước 2: Lưu sẵn hai số nguyên tố đầu tiên vào mảng
    primes[0] = 2;
    primes[1] = 3;

    // Bước 3: Tìm số nguyên tố từ 4 đến 100
    for (int p = 4; p <= 100; p++) {
        isPrime = 1;  // Giả định p là số nguyên tố

        // Kiểm tra p có chia hết cho số nguyên tố trước đó không
        for (int i = 0; i < primeIndex; i++) {
            if (p % primes[i] == 0) {
                isPrime = 0; // Nếu chia hết thì không phải số nguyên tố
                break;
            }
        }

        // Nếu là số nguyên tố, lưu vào mảng
        if (isPrime) {
            primes[primeIndex] = p;
            primeIndex++; // Tăng chỉ số lưu trữ số nguyên tố
        }
    }

    // Bước 4: Hiển thị các số nguyên tố tìm được
    printf("Cac so nguyen to tu 1 den 100 la:\n");
    for (int i = 0; i < primeIndex; i++) {
        printf("%d ", primes[i]);
    }

    printf("\n");
    return 0;
}
