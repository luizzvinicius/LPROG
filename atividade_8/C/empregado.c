#include <stdio.h>
#include <string.h>

typedef struct Departamento
{
    char nome[20];
    int id;
    char localizacao[50];
    struct Empregado empregados[100];
};
typedef struct Empregado
{
    char nome[50];
    int id;
    char cargo[50];
    double salario;
    struct Departamento departamento;
};
int cont = 1;

void inicializar(struct Empregado *e, char nome[50], int id, char cargo[50], double salario, struct Departamento *d)
{
    strcpy(e->nome, nome);
    e->id = id;
    e->salario = salario;
    e->departamento = *d;
}
void setNome(struct Empregado *e, char nome[]) {}

void setCargo(struct Empregado *e, char cargo[50])
{
    strcpy(e->cargo, cargo);
}

void setId(struct Empregado *e, int id)
{
    e->id = id;
}

void setDepartamento(struct Empregado *e, struct Departamento *d)
{
    e->departamento = *d;
}

void setSalario(struct Empregado *e, double salario)
{
    e->salario = salario;
}
void transferirEmpregado(struct Empregado *e, struct Departamento *d)
{
    e->departamento = *d;
}
void getDepartamento(struct Empregado *e)
{
    return e->departamento;
}

void addEmpregado(struct Departamento *d, struct Empregado *e)
{
    d->empregados[cont += 1] = *e;
}

void removeEmpregado(struct Departamento *d, struct Empregado *e, int pos)
{
    d->empregados[pos] = 0;
}

void infoEmpregado(struct Empregado *e)
{
    println("Nome: %s, Id: %d, cargo: %s, salario: %.2f", e->nome, e->cargo, e->salario);
}