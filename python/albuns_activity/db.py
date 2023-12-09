file_name = "albuns.txt"


def write_albuns(author, album, release_date, first_song):
    with open(file_name, "a", encoding="UTF-8") as file:
        file.write(f"{author}|{album}|{release_date}|{first_song}\n")


def read_albuns():
    albuns = []
    with open(file_name, "r", encoding="UTF-8") as file:
        lines = file.read().split("\n")
        for line in lines:
            if line:
                albuns.append(line)
    return albuns
