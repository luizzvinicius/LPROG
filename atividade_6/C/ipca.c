#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// typedef struct {
//     char* value;
// } String;

// typedef struct {
//     String* array;
//     size_t size;
// } ArrayList;

// void ArrayList_init(ArrayList* list) {
//     list->array = NULL;
//     list->size = 0;
// }

// void ArrayList_add(ArrayList* list, String value) {
//     list->array = (String*)realloc(list->array, (list->size + 1) * sizeof(String));
//     list->array[list->size] = value;
//     list->size++;
// }

// void ArrayList_destroy(ArrayList* list) {
//     free(list->array);
// }

int main() {
    char input[12];
    char meses[12][120];
    int cont = 0;
    do {
        printf("Digite as informacoes: (* para parar e maximo de 10 meses de entrada) ");
        fgets(input, 12, stdin);
        fgets(meses[cont], 12, stdin);
        input[strcspn(input, "\n")] = 0;
        // meses[cont][input] = 0;
        cont++; 
    } while (strcmp(input, "*") != 0);
    for (int i = 0; i < 120; i++)
    {
        printf("%s", meses[i]);
    }
    

    return 0;
}