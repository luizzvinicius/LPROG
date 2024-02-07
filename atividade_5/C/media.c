#include <stdio.h>

int main(int argc, char const *argv[])
{
    double notas[3];
    int pesos[3];
    double nota = 0;
    int peso = 0;
    for (int i = 0; i < 3; i++)
    {
        printf("Digite a %u nota: \n", i+1);
        scanf("%lf", &nota);
        printf("Digite o peso dessa nota: \n");
        scanf("%u", &peso);
        notas[i] = nota * peso;
        pesos[i] = peso;
    }
    double somaNotas = 0;
    for (int i = 0; i < sizeof(notas) / sizeof(notas[0]); i++)
    {
        somaNotas += notas[i];
    }
    double somaPesos = 0;
    for (int i = 0; i < sizeof(pesos) / sizeof(pesos[0]); i++)
    {
        somaPesos += pesos[i];
    }
    printf("A media ponderada e: %.2f", somaNotas / somaPesos);
    return 0;
};