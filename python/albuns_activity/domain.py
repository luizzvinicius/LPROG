# Regra de negócio
import db


def write_album(author, album, release_date, first_song):
    db.write_albuns(author, album, release_date, first_song)


def get_albuns():
    return db.read_albuns()


def get_album_by_author(author: str):
    selected_albuns = filter(lambda item: author in item.split("|")[0], get_albuns())
    return list(selected_albuns)


def get_album_same_year(date):
    selected_albuns = filter(lambda item: item.split("|")[2] == date, get_albuns())
    return list(selected_albuns)


def get_album_previous_year(date):
    selected_albuns = filter(lambda item: item.split("|")[2] <= date, get_albuns())
    return list(selected_albuns)


def get_album_next_year(date):
    selected_albuns = filter(lambda item: item.split("|")[2] > date, get_albuns())
    return list(selected_albuns)
