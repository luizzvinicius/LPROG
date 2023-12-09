import domain
from tkinter import *
from tkinter import ttk  # módulo mais compleot
from datetime import date

current_year = date.today().year
window = Tk()
window.title("Spotify")
root_width = window.winfo_screenwidth()
root_height = window.winfo_screenheight()
width = 520
height = 580
x_cordinate = int((root_width / 2) - (width / 2))
y_cordinate = int((root_height / 2) - (height / 2))
window.geometry(f"{width}x{height}+{x_cordinate}+{y_cordinate}")
window.resizable(FALSE, FALSE)
window.tk.call("source", "./python/albuns_activity/azure.tcl")
window.tk.call("set_theme", "dark")

lbl_autor = ttk.Label(window, text="Autor: ")
lbl_autor.grid(row=0, column=0, sticky="w", padx=16)
entry_autor = ttk.Entry(window, name="autor", width=50)
entry_autor.grid(row=0, column=1, pady=10)

lbl_album = ttk.Label(window, text="Álbum: ")
lbl_album.grid(row=1, column=0, sticky="w", padx=16)
entry_album = ttk.Entry(window, name="album", width=50)
entry_album.grid(row=1, column=1, pady=10)

lbl_date = ttk.Label(window, text="Data lançamento: ")
lbl_date.grid(row=2, column=0, padx=16)
entry_date = ttk.Spinbox(window, from_=1900, to=current_year)
entry_date.grid(row=2, column=1, sticky="W", pady=10)

v0 = BooleanVar()
v0.set(False)
check_first = ttk.Checkbutton(window, text="Álbum lançamento", variable=v0)
check_first.grid(row=2, column=1, sticky="e")

lbl = ttk.Label(window, text=" ")


def cadastra_album(e):
    autor = entry_autor.get()
    nome_album = entry_album.get()
    release_date = entry_date.get()
    first_album = v0.get()
    if "" in [autor, nome_album, release_date] or release_date > str(current_year):
        lbl.configure(text="Algum campo no cadastro está vazio. Ou data é inválida")
    else:
        domain.write_album(autor, nome_album, release_date, first_album)
        lbl.configure(text="Álbum cadastrado")


btn_create = ttk.Button(window, text="Criar álbum")
btn_create.bind("<Button-1>", func=cadastra_album)
btn_create.grid(row=3, column=1, sticky="W", pady=10)

lbl.grid(row=4, column=1)

def crate_label(window, text, colum=0, row=0):
    lbl = ttk.Label(window, text=text)
    lbl.pack()

def search_albuns(e):
    global window
    second_screen = Toplevel(window)
    second_screen.title("Busca de álbuns")
    second_screen.geometry(f"{width}x{height}+{x_cordinate}+{y_cordinate}")
    second_screen.resizable(FALSE, FALSE)


    lbl_autor = ttk.Label(second_screen, text="Autor para pesquisar:")
    lbl_autor.pack()
    entry_autor = ttk.Entry(second_screen, name="autor", width=50)
    entry_autor.pack()
    lbl_error = ttk.Label(second_screen, text="")
    lbl_error.pack()

    tr = ttk.Treeview(second_screen, columns=('Autor', 'Álbum', 'Ano lançamento', 'Lançamento do Artista'), show='headings')
    tr.column('Autor', minwidth=10, width=80, anchor='w')
    tr.column('Álbum', minwidth=10, width=80, anchor='center')
    tr.column('Ano lançamento', minwidth=10, width=120, anchor='center')
    tr.column('Lançamento do Artista', minwidth=30, width=160, anchor='center')
    tr.heading('Autor', text='Autor')
    tr.heading('Álbum', text='Álbum')
    tr.heading('Ano lançamento', text='Ano lançamento')
    tr.heading('Lançamento do Artista', text='Lançamento do Artista')
    tr.pack()


    frame_radio = ttk.Frame(second_screen)
    frame_radio.pack()
    v0 = IntVar()
    v0.set(0)
    r1=ttk.Radiobutton(frame_radio, text="Anterior a", variable=v0, value=1)
    r2=ttk.Radiobutton(frame_radio, text="Igual a", variable=v0, value=2)
    r3=ttk.Radiobutton(frame_radio, text="Posterior a", variable=v0, value=3)
    r1.pack(anchor='w')
    r2.pack(anchor='w')
    r3.pack(anchor='w')

    data = [str(i) for i in range(1900, current_year, 4)]
    cb = ttk.Combobox(second_screen, values=data)
    cb.pack()

    def get_specific_album(e):
        if entry_autor.get() == '' and v0.get() == 0:
            lbl_error.configure(text="Nome do Autor está vazio")
            return

        if entry_autor.get() and v0.get() in (1,2,3) and cb.get():
            lbl_error.configure(text="Forma de busca inválida")
            return

        for i in tr.get_children():
            tr.delete(i)

        specific_albuns = []
        if entry_autor.get():
            specific_albuns = domain.get_album_by_author(entry_autor.get())
        elif v0.get() == 1:
            specific_albuns = domain.get_album_previous_year(cb.get())
        elif v0.get() == 2:
            specific_albuns = domain.get_album_same_year(cb.get())
        elif v0.get() == 3:
            specific_albuns = domain.get_album_next_year(cb.get())
        
        if len(specific_albuns) == 0:
            lbl_error.configure(text="Nenhum autor com esses filtros cadastrado")
            return
        for item in specific_albuns:
            item = item.split("|")
            tr.insert('', 'end', values=[item[0], item[1], item[2], item[3]])

    btn_search1 = ttk.Button(second_screen, text="Pesquisar")
    btn_search1.bind("<Button-1>", func=get_specific_album)
    btn_search1.pack(pady=20)

    btn_voltar = ttk.Button(second_screen, text="Voltar para tela principal", command=second_screen.destroy)
    btn_voltar.pack()


btn_search = ttk.Button(window, text="Mostrar todos os álbuns")
btn_search.bind("<Button-1>", search_albuns)
btn_search.grid(row=5, column=1, sticky="w")

window.mainloop()
