#include <stdio.h>

int main(int argc, char const *argv[])
{
    double temp = 0;
    printf("Digite uma temperatura em °C para converter para °F: ");
    scanf("%Lf", &temp);
    fflush(stdin);
    printf("%.1f °C é equivalente a %.1f ºF", temp, temp * 1.8 + 32);
    return 0;
};