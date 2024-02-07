#include <stdio.h>

int main() 
{
    int num = 0;
    printf("Digite um numero para saber se eh par ou impar: ");
    scanf("%u", &num);
    fflush(stdin);
    printf(num % 2 == 0 ? "Par" : "Impar");
    return 0;
};