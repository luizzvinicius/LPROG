#include <stdio.h>

int main()
{
    int jogos = 0;
    printf("Quantos jogos foram vendidos? ");
    scanf("%d", &jogos);
    double VALOR_JOGO = 19.9;
    double total = jogos * VALOR_JOGO;
    double bonus = jogos / 15 > 0 ? total * (jogos / 15 * 0.08) : 0;
    double salarioCatarina = total / 2 + bonus;
    printf("%.2f %.2f %.2f", total, bonus, salarioCatarina);
    return 0;
}