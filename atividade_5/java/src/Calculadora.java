import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        try (var scan = new Scanner(System.in)) {
            System.out.print("Digite o 1° número: ");
            var n1 = scan.nextDouble();
            System.out.print("Digite o 2° número: ");
            var n2 = scan.nextDouble();
            
            System.out.printf("Soma entre %.1f e %.1f é: %.1f%n", n1, n2, n1 + n2);
            System.out.printf("Subtração entre %.1f e %.1f é: %.1f%n", n1, n2, n1 - n2);
            System.out.printf("Multiplicação entre %.1f e %.1f é: %.1f%n", n1, n2, n1 * n2);
            System.out.printf("Divisão entre %.1f e %.1f é: %.2f%n", n1, n2, n1 / n2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}