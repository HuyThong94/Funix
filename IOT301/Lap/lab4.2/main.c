#include <stdio.h>
#include <stdlib.h>

enum Company {
    GOOGLE,
    FACEBOOK,
    XEROX,
    YAHOO,
    EBAY,
    MICROSOFT
};

int main()
{
    enum Company myCompany;
    myCompany = GOOGLE;

    printf("My company ID is: %d\n", myCompany);
    return 0;
}
