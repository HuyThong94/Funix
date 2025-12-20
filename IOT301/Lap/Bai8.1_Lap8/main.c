#include <stdio.h>
#include <stdlib.h>

#define length 5
int main()
{
    int arrayList[length] = { 10, 20, 30, 40, 50};
    for(unsigned int i = 0; i < length;i++){
        printf("gia tri tung phan tu: %d\n", arrayList[i]);
    }
    return 0;
}
