from tkinter import *
from tkinter import ttk # módulo mais compleot

data = ("Calabreso", "Perereco")

def on_click(event):
    lbl.configure(text='Sua mãe é minha')
    print(event)

window = Tk()
window.title("Sistema de cadastro")
window.geometry('400x400')
window.tk.call("source", "./python/albuns_activity/azure.tcl")
window.tk.call("set_theme", "light")

btn = ttk.Button(window, text='Clique aqui')
btn.bind("<Double-Button-1>", func=on_click)
btn.place(x=140, y=10, height=36)
txtfld = ttk.Entry(window, text="Digite aqui", name="jorge")
txtfld.place(x=10, y=10, width=120, height=36,)
lbl = Label(window, text='Ola')
lbl.place(x=0, y=46)
box=ttk.Combobox(window, value=data)
box.place(x=0, y=66)
list_box = Listbox(window, height=12, selectmode='multiple')

for item in data:
    list_box.insert(END, item)

list_box.place(x=0, y=100)

v0 = StringVar()
v0.set("Java")
# deve ter mesmo variable
r1 = ttk.Radiobutton(window, text="Java", variable=v0, value="Java")
r2 = ttk.Radiobutton(window, text="Python", variable=v0, value="Python")
r1.place(x=200, y=200)
r2.place(x=280, y=200)


v1 = IntVar()
v2 = IntVar()
c1 = ttk.Checkbutton(window, text = "Futebol", variable = v1)
c2 = ttk.Checkbutton(window, text = "Tenis", variable = v2)
c1.place(x=200, y=250)
c2.place(x=280, y=250)

window.mainloop()
