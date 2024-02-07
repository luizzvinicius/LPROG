import java.util.Scanner;

public class Temperatura {
    public static void main(String[] args) {
        try (var scan = new Scanner(System.in)) {
            System.out.print("Digite uma temperatura em C°: ");
            var tempC = scan.nextDouble();
            System.out.printf("%.1f em C° corresponde a %.1f F°%n", tempC, tempC * 1.8 + 32);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}