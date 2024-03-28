#include <stdio.h>
#include <string.h>

typedef struct Livro
{
    char titulo[100];
    char autor[30];
    int ano;
    int copias;
};

void inicializar(struct Livro *l, char titulo[], char autor[], int ano, int copias)
{
    strcpy(l->titulo, titulo);
    strcpy(l->autor, autor);
    l->ano = ano;
    l->copias = copias;
}
void emprestaCopia(struct Livro *l)
{
    l->copias--;
}
void devolveCopia(struct Livro *l)
{
    l->copias++;
}
int verificaCopia(struct Livro *l)
{
    return l->copias;
}