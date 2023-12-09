# Regra de negócio
import db


def write_album(author, album, release_date, first_song):
    db.write_albuns(author, album, release_date, first_song)


def get_albuns():
    return db.read_albuns()


def get_album_by_author(author: str):
    albuns = get_albuns()
    selected_albuns = []
    print(albuns)
    for album in albuns:
        values = album.split("|")
        if author.lower() in values[1].lower():
            selected_albuns.append(values[1])
    return selected_albuns
