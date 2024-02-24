package atividade_6.java;

import java.util.Scanner;

public class Pi {
    public static void main(String[] args) {
        try (var scan = new Scanner(System.in)) {
            System.out.print("Digite a quantidade de termos da sequência: ");
            var termos = scan.nextInt();
            var sum = 0d;
            var denominador = 1;
            for (int i = 0; i < termos; i++) {
                sum = i % 2 == 0 ? sum + (1 / Math.pow(denominador, 3)) : sum - (1 / Math.pow(denominador, 3));
                denominador += 2;
            }
            System.out.printf("Pi = %.5f%n", Math.cbrt(sum * 32));
        } catch (Exception e) {
            System.out.println(e);
        }
    }   
}