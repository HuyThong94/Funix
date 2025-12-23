#include <stdio.h>
#include <stdlib.h>

enum Company
{
    GOOGLE,
    FACEBOOK,
    XEROX = 7,
    YAHOO,
    EBAY,
    MICROSOFT
};

int main()
{
    enum Company google = GOOGLE;
    enum Company facebook = FACEBOOK;
    enum Company xerox = XEROX;
    enum Company yahoo = YAHOO;
    enum Company ebay = EBAY;
    enum Company microsoft = MICROSOFT;
    printf("The value of google is: %d\n", google);
    printf("The value of facebook is: %d\n", facebook);
    printf("The value of xerox is: %d\n", xerox);
    printf("The value of yahoo is: %d\n", yahoo);
    printf("The value of ebay is: %d\n", ebay);
    printf("The value of microsoft is: %d\n", microsoft);

    return 0;
}
