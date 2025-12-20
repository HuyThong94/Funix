#include <stdio.h>
#include <stdlib.h>

// Prototype của các hàm
int ucln(int a, int b);
float absolute(float x);
long long factorial(int n);
float distance(float Ax, float Ay, float Bx, float By);
int main()
{int a, b, n;
    float x, Ax, Ay, Bx, By;

    // Nhập và tính UCLN
    printf("Nhập hai số nguyên không âm: ");
    scanf("%d %d", &a, &b);
    printf("Ước chung lớn nhất của %d và %d là: %d\n", a, b, ucln(a, b));

    // Nhập và tính giá trị tuyệt đối
    printf("\nNhập một số thực: ");
    scanf("%f", &x);
    printf("Giá trị tuyệt đối của %.2f là: %.2f\n", x, absolute(x));

    // Nhập và tính giai thừa
    printf("\nNhập một số nguyên không âm để tính giai thừa: ");
    scanf("%d", &n);
    printf("Giai thừa của %d là: %lld\n", n, factorial(n));

    // Nhập và tính khoảng cách
    printf("\nNhập tọa độ điểm A (Ax, Ay): ");
    scanf("%f %f", &Ax, &Ay);
    printf("Nhập tọa độ điểm B (Bx, By): ");
    scanf("%f %f", &Bx, &By);
    printf("Khoảng cách giữa A và B là: %.2f\n", distance(Ax, Ay, Bx, By));

    return 0;
}

int uocChungLonNhat(unsigned int a, unsigned int b){
    int r;
    while(b != 0){
        r = a%b;
        a = b;
        b = r;
    }
    return a;
}
float giaTriTuyetDoi(float x){
    if(x < 0){
        return -x;
    }
    return x;
}
long giaiThua(int n){
    if(n == 0){
        return 1;
    }
    else{
        return n * giaiThua(n-1);
    }
}
float khoangCach(float Ax, float Ay, float Bx, float By){
    return sqrt((Ax-Bx)*(Ax-Bx)+(Ay-By)*(Ay-By));
}
