#include <stdio.h>
#include <math.h>
#include <stdbool.h>

#define EPSILON 0.01

double Ax,Ay,Bx,By,Cx,Cy;
double mangToaDo[6];
double AB, BC, CA, angleA, angleB, angleC;
double centroid_x, centroid_y;
nhapToaDoCacDiem();
bool kiemtra_tamgiac(double mangToaDo[]);
goccanh_tamgiac();
xet_tamgiac(double mangToaDo[]);
dientich_tamgiac(double mangToaDo[]);

int main() {
    nhapToaDoCacDiem();
    printf("----------------------------------------------------------\n");
    double x1 = mangToaDo[0], y1 = mangToaDo[1], x2 = mangToaDo[2], y2 = mangToaDo[3], x3 = mangToaDo[4], y3 = mangToaDo[5];
     AB = distance(x1, y1, x2, y2);
     BC = distance(x2, y2, x3, y3);
     CA = distance(x3, y3, x1, y1);
    if(kiemtra_tamgiac(mangToaDo)){
        printf("3 diem A(%.2f %.2f), B(%.2f %.2f, C(%.2f %.2f) tao thanh 1 tam giac\n", Ax, Ay, Bx, By, Cx, Cy);
    }else{
        printf("3 diem A(%.2f %.2f), B(%.2f %.2f, C(%.2f %.2f) khong tao thanh 1 tam giac\n", Ax, Ay, Bx, By, Cx, Cy);
    }
    if(kiemtra_tamgiac(mangToaDo)){
    goccanh_tamgiac();
    xet_tamgiac(mangToaDo);
    dientich_tamgiac(mangToaDo);
    }
    return 0;
}

// Hàm kiểm tra điều kiện tạo thành tam giác
bool kiemtra_tamgiac(double mangToaDo[]) {
    double x1 = mangToaDo[0], y1 = mangToaDo[1], x2 = mangToaDo[2], y2 = mangToaDo[3], x3 = mangToaDo[4], y3 = mangToaDo[5];
    int area = x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2);
    return area != 0;
}

nhapToaDoCacDiem(){
    //Toa do diem A
    printf("Nhap toa do diem A:\n");
    printf("Ax: ");
    scanf("%lf", &Ax);
    mangToaDo[0] = Ax;
    printf("Ay: ");
    scanf("%lf", &Ay);
    mangToaDo[1] = Ay;
    // Toa do diem B
    printf("Nhap toa do diem B:\n");
    printf("Bx: ");
    scanf("%lf", &Bx);
    mangToaDo[2] = Bx;
    printf("By: ");
    scanf("%lf", &By);
    mangToaDo[3] = By;
    //Toa do diem C
    printf("Nhap toa do diem C:\n");
    printf("Cx: ");
    scanf("%lf", &Cx);
    mangToaDo[4] = Cx;
    printf("Cy: ");
    scanf("%lf", &Cy);
    mangToaDo[5] = Cy;

    //In thong tin cac diem
    printf("Toa do diem A da nhap: A(%.2f %.2f)\n", Ax, Ay);
    printf("Toa do diem B da nhap: B(%.2f %.2f)\n", Bx, By);
    printf("Toa do diem C da nhap: C(%.2f %.2f)\n", Cx, Cy);
}

// Hàm tính khoảng cách giữa hai điểm
double distance(int x1, int y1, int x2, int y2) {
    return sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
}

// Hàm tính góc trong tam giác (đổi radian sang độ)
double calculateAngle(double a, double b, double c) {
    return acos((b * b + c * c - a * a) / (2 * b * c)) * (180.0 / M_PI);
}
goccanh_tamgiac(){
    // Xuất kết quả
    printf("Chieu dai canh AB: %.2lf\n", AB);
    printf("chieu dai canh BC: %.2lf\n", BC);
    printf("Chieu dai canh CA: %.2lf\n", CA);

    printf("Goc A = %.2lf\n", angleA);
    printf("Goc B = %.2lf\n", angleB);
    printf("Goc C = %.2lf\n", angleC);
}
xet_tamgiac(){

    // Tính các góc trong tam giác
    double angleA = calculateAngle(AB, BC, CA);
    double angleB = calculateAngle(BC, CA, AB);
    double angleC = calculateAngle(CA, AB, BC);

    int isRight = (fabs(angleA - 90) <= EPSILON || fabs(angleB - 90) <= EPSILON || fabs(angleC - 90) <= EPSILON);
    int isAcute = (angleA < 90 && angleB < 90 && angleC < 90);
    int isObtuse = (angleA > 90 || angleB > 90 || angleC > 90);
    int isEquilateral = (fabs(AB - BC) <= EPSILON && fabs(BC - CA) <= EPSILON);
    int isIsosceles = (fabs(AB - BC) <= EPSILON || fabs(BC - CA) <= EPSILON || fabs(CA - AB) <= EPSILON);

    if (isEquilateral) {
        printf("ABC la tam giac deu.\n");
    } else if (isRight && isIsosceles) {
        printf("ABC la tam giac vuong can tai dinh ");
        if (fabs(angleA - 90) <= EPSILON) printf("A\n");
        else if (fabs(angleB - 90) <= EPSILON) printf("B\n");
        else printf("C\n");
    } else if (isObtuse && isIsosceles) {
        printf("ABC la tam giac tu va can tai dinh ");
        if (angleA > 90) printf("A\n");
        else if (angleB > 90) printf("B\n");
        else printf("C\n");
    } else if (isAcute && isIsosceles) {
        printf("ABC la tam giac can tai dinh ");
        if (fabs(AB - BC) <= EPSILON) printf("C\n");
        else if (fabs(BC - CA) <= EPSILON) printf("A\n");
        else printf("B\n");
    } else {
        printf("ABC la tam giac ");
        if (isRight) {
            printf("vuong tai dinh ");
            if (fabs(angleA - 90) <= EPSILON) printf("A\n");
            else if (fabs(angleB - 90) <= EPSILON) printf("B\n");
            else printf("C\n");
        } else if (isObtuse) {
            printf("tu tai dinh ");
            if (angleA > 90) printf("A\n");
            else if (angleB > 90) printf("B\n");
            else printf("C\n");
        } else {
            printf("nhon.\n");
        }
    }
}
// Hàm tính diện tích tam giác theo công thức Heron
 dientich_tamgiac() {
    double s = (AB + BC + CA) / 2;
    double area = sqrt(s * (s - AB) * (s - BC) * (s - CA));
    printf("2. Dien tich tam giac ABC la: %.2lf", area);
}

// Hàm tính độ dài các đường cao
 duongcao_tamgiac(double mangToaDo) {
    static double heights[3];
    double perimeter = AB + BC + CA;
    //Cong thu tinh duong cao h = 2*can bac hai cua( p*(p-a)*(p-b)*(p-c))/2
    heights[0] = round((2 * area / AB) * 100) / 100;
    heights[1] = round((2 * area / BC) * 100) / 100;
    heights[2] = round((2 * area / CA) * 100) / 100;
    printf("Do dai duong cao tu dinh A la: ");
    printf("Do dai duong cao tu dinh B la: ");
    printf("Do dai duong cao tu dinh C la: ");

}


