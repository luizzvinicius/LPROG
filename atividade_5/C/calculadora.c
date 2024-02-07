#include <stdio.h>

int main(int argc, char const *argv[])
{
    double num = 0;
    double num2 = 0;
    printf("Digite digite o 1 número: ");
    scanf("%Lf", &num);
    printf("Digite digite o 2 número: ");
    scanf("%Lf", &num2);
    fflush(stdin);
    printf("A soma entre %.2f e %.2f é %.2f\n", num, num2, num + num2);
    printf("A subtração entre %.2f e %.2f é %.2f\n", num, num2, num - num2);
    printf("A multiplicação entre %.2f e %.2f é %.2f\n", num, num2, num * num2);
    printf("A divisão entre %.2f e %.2f é %.2f\n", num, num2, num / num2);
    return 0;
};