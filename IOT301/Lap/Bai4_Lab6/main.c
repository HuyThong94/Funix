#include <stdio.h>
#include <stdlib.h>

#define PAYRATE 12.00
#define TAXRATE_300 0.15
#define TAXRATE_450 0.20
#define TAXRATE_REST 0.25
#define OVERTIME 40
int main()
{
    unsigned int soGiolam = 0;
    double luongGross = 0.0;
    double thue = 0.0;
    double luongNet = 0.0;
    printf("Nhap so gio lam viec: ");
    scanf("%d", &soGiolam);
    if(soGiolam <= OVERTIME)
    {
        luongGross =  soGiolam * PAYRATE;
    }
    else
    {
        luongGross = OVERTIME * PAYRATE;
        luongGross += (soGiolam - OVERTIME)* PAYRATE *1.5;
    }
    if(luongGross <= 300)
    {
        thue = luongGross * TAXRATE_300;
    }
    else if(luongGross > 300 && luongGross <= 450)
    {
        thue = 300 * TAXRATE_300;
        thue += (luongGross - 300)* TAXRATE_450;
    }
    else
    {
        thue = 300 * TAXRATE_300;
        thue += 150 *  TAXRATE_450;
        thue += (luongGross - 450) * TAXRATE_REST;
    }
    luongNet = luongGross - thue;
    printf("Your gross pay this week is: %.2f\n", luongGross);
    printf("Your taxes this week is: %.2f\n", thue);
    printf("Your net pay this week is: %.2f\n", luongNet);
    return 0;
}
