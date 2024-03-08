package atividade_7;

import java.util.Scanner;

public class SomaNumeros {
    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in);) {
            System.out.print("Digite um número inteiro positivo: ");
            int n = scanner.nextInt();
            
            long start = System.currentTimeMillis();
            int soma = soma(n);

            // int soma = 0;
            // for (int i = 1; i <= n; i++) {
            //     soma += i;
            // }
            long fim = System.currentTimeMillis();
            long elapsed = fim - start;
            
            System.out.println("A soma dos números de 1 a " + n + " é: " + soma);
            System.out.printf("\nTempo: %d\n", elapsed);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int soma(int n) {
        if (n == 0) {
            return 0;
        }
        return n + soma(n - 1);
    }
}