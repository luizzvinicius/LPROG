#include <stdio.h>

int main()
{
    int idade = 0;
    printf("Digite sua idade e verifique se eh maior de idade: ");
    scanf("%u", &idade);
    fflush(stdin);
    printf(idade < 18 ? "Menor de idade" : "Maior de idade");
    return 0;
};