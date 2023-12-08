file_name = "albuns.txt"


# nome do álbum, ano de lançamento, nome da banda/artista, álbum lançamento do artista (sim/não)
# Criar uma tela que liste todos os álbuns cadastrados na sua base de dados.
def write_names(author, album, release_date, first_song=False):
    with open(file_name, 'a', encoding="UTF-8") as file:
        file.write(f'{author}|{album}|{release_date}|{first_song};\n')


def read_names():
    with open(file_name, 'r', encoding="UTF-8") as file:
        people = file.read()
        for person in people.split('\n'):
            values = person.split('|')
            sexo = "Masculino" if values[2] == "M" else "Feminino"
            print(
                f"\nNome: {values[0]}\nIdade: {values[1]} anos\nSexo: {sexo}\nTelefone: {values[3]}")


def get_peOple_gender(gender_param):
    with open(file_name, 'r', encoding="UTF-8") as file:
        people = file.read()
        for person in people.split("\n"):
            row = person.split("|")
            if row[2] == gender_param:
                print(
                    f"\nNome: {row[0]}\nIdade: {row[1]} anos\nSexo: {row[2]}\nTelefone: {row[3]}")


def find_user(search_name: str):
    with open(file_name, 'r', encoding="UTF-8") as file:
        people = file.read()
        for person in people.split("\n"):
            row = person.split("|")
            if search_name.lower() in row[0].lower():
                print(
                    f"\nNome: {row[0]}\nIdade: {row[1]} anos\nSexo: {row[2]}\nTelefone: {row[3]}")


# def get_filtered_users(predicate: bool):
#     with open(file_name, 'r', encoding="UTF-8") as file:
#         people = file.read()
#         for person in people.split("\n"):
#             row = person.split("|")
#             if predicate:
#                 print(
#                     f"\nNome: {row[0]}\nIdade: {row[1]} anos\nSexo: {row[2]}\nTelefone: {row[3]}")


def main():
    if __name__ == '__main__':
        write_names("Taylor swift", "Lover", 2019)


main()
