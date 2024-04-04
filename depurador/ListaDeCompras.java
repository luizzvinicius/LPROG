import java.util.ArrayList;

public class ListaDeCompras {
    public static void main(String[] args) {
        ListaDeCompras lista = new ListaDeCompras();
        lista.adicionarItem("Maçã");
        lista.adicionarItem("Banana");
        lista.adicionarItem("Pêra");
        lista.removerItem("Banana");
        lista.removerItem("Laranja");
        lista.exibirLista();
    }

    private ArrayList<String> itens;

    public ListaDeCompras() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(String item) {
        this.itens.add(item);
    }

    public void removerItem(String item) {
        if (!this.itens.contains(item)) {
            System.out.printf("O item %s não está na lista.\n", item);
            return;
        }
        this.itens.remove(item);
    }

    public void exibirLista() {
        System.out.println("Lista de Compras:");
        this.itens.forEach(item -> System.out.printf("- %s\n", item));
    }
}