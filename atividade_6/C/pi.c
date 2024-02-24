#include <stdio.h>
#include <math.h>

int main() {
    printf("Digite a quantidade de termos da sequencia: ");
    int termos;
    scanf("%d", &termos);
    double sum = 0.0;
    int denominador = 1;
    for (int i = 0; i < termos; i++) {
        sum = i % 2 == 0 ? sum + 1 / pow(denominador, 3) : sum - (1 / pow(denominador, 3));
        denominador += 2;
    }
    printf("Pi = %.5f\n", cbrt(sum * 32));
    return 0;
}