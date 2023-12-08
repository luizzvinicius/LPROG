import domain
from tkinter import *
from tkinter import ttk  # módulo mais compleot
from datetime import date

tamanho_input = 300
window = Tk()
window.title("Spotify")
window.geometry("700x450")
window.resizable(FALSE, FALSE)
window.tk.call("source", "./python/albuns_activity/azure.tcl")
window.tk.call("set_theme", "dark")

def search_albuns(e):
    global window
    segunda_tela = Toplevel(window)
    segunda_tela.title("Busca de álbuns")
    segunda_tela.geometry("400x400")
    segunda_tela.resizable(FALSE, FALSE)

    rotulo_segunda_tela = ttk.Label(segunda_tela, text="Você está na segunda tela!")
    rotulo_segunda_tela.pack()

    def botao_voltar_click():
        segunda_tela.destroy()

    botao_voltar = ttk.Button(segunda_tela, text="Voltar", command=botao_voltar_click)
    botao_voltar.pack()

frame1 = ttk.Frame(window, borderwidth=1, relief="solid", width=tamanho_input, height=150)
frame1.pack()

lbl_autor = ttk.Label(frame1, text="Autor: ")
lbl_autor.pack()
entry_autor = ttk.Entry(frame1, name="autor", width=tamanho_input)
entry_autor.pack()

lbl_album = ttk.Label(frame1, text="Álbum: ")
lbl_album.pack()
entry_album = ttk.Entry(frame1, name="album", width=tamanho_input)
entry_album.pack()

lbl_date = ttk.Label(frame1, text="Data lançamento: ")
lbl_date.pack()
entry_date = ttk.Spinbox(frame1, from_=1900, to=date.today().year, width=tamanho_input)
entry_date.pack()

v0 = BooleanVar()
v0.set(False)
check_first = ttk.Checkbutton(frame1, text="Álbum lançamento", variable=v0)
check_first.pack()

btn_search = ttk.Button(window, text="Mostrar todos os álbuns")
btn_search.bind("<Button-1>", search_albuns)
btn_search.pack()

def cadastra_album(e):
    autor = entry_autor.get()
    nome_album = entry_album.get()
    release_date = entry_date.get()
    first_album = v0.get()
    message = ''
    if '' in [autor, nome_album, release_date] or int(release_date) > date.today().year:
        message = 'Algum campo no cadastro está vazio. Ou data é inválida'
    else:
        message = 'Álbum cadastrado'
        domain.write_album(autor, nome_album, release_date, first_album)
    lbl = ttk.Label(window, text=message)
    lbl.pack()


btn_create = ttk.Button(window, text="Criar álbum")
btn_create.bind("<Button-1>", func=cadastra_album)
btn_create.pack()



lbl_teste = ttk.Label(frame1, text=entry_autor.get())
lbl_teste.pack()

window.mainloop()
