import java.util.Scanner;

public class Par {
    public static void main(String[] args) {
        try (var scan = new Scanner(System.in)) {
            System.out.print("Digite um número para verificar se é par ou ímpar: ");
            int num = scan.nextInt();
            System.out.println(num % 2 == 0 ? "Par" : "Ímpar"); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
