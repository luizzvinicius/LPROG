#include <stdio.h>
#include <string.h>

int main() {
    int passagers = 5;
    for (int i = 1; i <= passagers; i++) {
        printf("Possui RG? ");
        char rg[10];
        scanf("%s", rg);

        printf("Qual a data de nascimento? ");
        int birthDate;
        scanf("%d", &birthDate);
        
        printf("Possui passagem? ");
        char ticket[10];
        scanf("%s", ticket);
        
        printf("Qual data de nascimento no bilhete? ");
        int travelDate;
        scanf("%d", &travelDate);
        
        printf("Qual assento? ");
        char seat[10];
        scanf("%s", seat);
        
        if (strstr(strlwr(rg), "nao")) {
            printf("a saida eh nessa direcao\n");
            continue;
        }
        if (strstr(strlwr(ticket), "nao")) {
            printf("a recepcao eh nessa direcao\n");
            continue;
        }
        if (travelDate != birthDate) {
            printf("190\n");
            continue;
        }
        printf("Passageiro %d seu assento e: %s. tenha um otimo dia\n\n", i, seat);
    }
    return 0;
}