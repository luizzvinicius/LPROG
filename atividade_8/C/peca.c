#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Peca {
    char tipo[20];
    char cor[20];
    char posicao[3];
};

void inicializarPeca(struct Peca *p, char tipo[], char cor[], char posicao[]) {
    strcpy(p->tipo, tipo);
    strcpy(p->cor, cor);
    strcpy(p->posicao, posicao);
}

void moverPeca(struct Peca *p, char pos[]) {
    strcpy(p->posicao, pos);
}

int capturaPeca(struct Peca *p, char type[], char posOrigem[], char posDestino[]) {
    if (!verificaPosicao(type, posOrigem, posDestino)) {
        return 0;
    }
    moverPeca(p, posDestino);
    return 1;
}

int verificaPosicao(char type[], char posOrigem[], char posDestino[]) {
    if (strcmp(type, "cavalo") == 0 && strcmp(posOrigem, posDestino) != 0) {
        return 1;
    }
    return 0;
}