#include <stdio.h>
#include <stdlib.h>

#define length 8
int main()
{
    int list[length] = {10, 20, 30, 40, 50, 60, 70, 80};
    for(unsigned int i = length - 1; i >= 0; i--){
        printf("Gia tri tung phan tu la: %d\n", list[i]);
    }
    return 0;
}
