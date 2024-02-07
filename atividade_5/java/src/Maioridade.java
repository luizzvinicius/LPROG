import java.util.Scanner;

public class Maioridade {
    public static void main(String[] args) {
        try (var scan = new Scanner(System.in)) {
            System.out.print("Digite sua idade e verifique se é maior de idade: ");
            int idade = scan.nextInt();
            System.out.println(idade < 18 ? "Menor de idade" : "Maior de idade");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}