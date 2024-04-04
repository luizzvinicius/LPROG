import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ControleEstoque {
    private static Map<String, Integer> estoque = new HashMap<>();
    private static String[] opcoes = { "Adicionar Produto", "Vender Produto", "Exibir Estoque", "Sair" };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showOptions();
            int opcao = readInt(scanner, "Escolha uma opção: ");

            switch (opcao) {
                case 1 -> adicionarProduto(scanner);
                case 2 -> venderProduto(scanner);
                case 3 -> exibirEstoque();
                case 4 -> { System.out.println("Saindo do programa..."); return; }
                default -> System.out.println("Opção inválida!\n");
            }
        }
    }

    private static void adicionarProduto(Scanner scanner) {
        String nome = readString(scanner, "Digite o nome do produto: ");
        int quantidade = readInt(scanner, "Digite a quantidade do produto: ");
        if (estoque.containsKey(nome)) {
            quantidade += estoque.get(nome);
        }
        estoque.put(nome, quantidade);
        System.out.println("Produto adicionado com sucesso!\n");
    }

    private static void venderProduto(Scanner scanner) {
        String nome = readString(scanner, "Digite o nome do produto: ");
        if (!estoque.containsKey(nome)) {
            System.out.println("Produto não encontrado em estoque!\n");
            return;
        }
        
        int quantidade = readInt(scanner, "Digite a quantidade a ser vendida: ");
        if (quantidade > estoque.get(nome)) {
            System.out.println("Quantidade insuficiente em estoque!\n");
            return;
        }

        estoque.put(nome, estoque.get(nome) - quantidade);
        System.out.println("Venda realizada com sucesso!\n");
    }

    private static void exibirEstoque() {
        System.out.println("Estoque atual:");
        estoque.keySet().forEach(product -> System.out.printf("%s: %d\n", product, estoque.get(product)));
    }

    private static void showOptions() {
        for (int i = 0; i < opcoes.length; i++) {
            System.out.printf("%d- %s\n", i + 1, opcoes[i]);
        }
    }

    private static String readString(Scanner s, String message) {
        System.out.print(message);
        String input = s.nextLine();
        return input;
    }

    private static int readInt(Scanner s, String msg) {
        while (true) {
            System.out.print(msg);
            var num = s.nextLine();
            try {
                return Integer.parseInt(num);
            } catch (NumberFormatException e) {
                System.out.printf("Número inteiro inválido. %s%n%n", e.getMessage());
            }
        }
    }
}