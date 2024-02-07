import java.util.ArrayList;
import java.util.Scanner;

public class Media {
    public static void main(String[] args) {
        try (var scan = new Scanner(System.in)) {
            var notasComPeso = new ArrayList<Double>();
            var pesos = new ArrayList<Double>();
            final int MARKS = 3;
            double nota = 0;
            double peso = 0;
            for (var i = 1; i <= MARKS; i++) {
                System.out.printf("Digite a %d° nota: ", i);
                nota = scan.nextDouble();
                System.out.printf("Digite o peso dessa nota: ");
                peso = scan.nextDouble();
                notasComPeso.add(nota * peso);
                pesos.add(peso);
            }
            var somaNotas = notasComPeso.stream().reduce(0d, Double::sum);
            var somaPesos = pesos.stream().reduce(0d, Double::sum);
            System.out.printf("A média Ponderada é: %.2f", somaNotas / somaPesos);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}