package atividade_6.java;

import java.util.Scanner;

public class Aeroporto {
    public static void main(String[] args) {
        final int PASSAGERS = 5;
        try (var scan = new Scanner(System.in)) {
            for (var i = 1; i <= PASSAGERS; i++) {
                System.out.print("Possui RG? ");
                var rg = scan.next();
                System.out.print("Qual a data de nascimento? ");
                var birthDate = scan.nextInt();
                System.out.print("Possui passagem? ");
                var ticket = scan.next();
                System.out.print("Qual data de nascimento no bilhete? ");
                var travelDate = scan.nextInt();
                System.out.print("Qual assento? ");
                var seat = scan.next();

                if (rg.toLowerCase().contains("nao")) {
                    System.out.println("a saída é nessa direção");
                    continue;
                }
                if (ticket.toLowerCase().contains("nao")) {
                    System.out.println("a recepção é nessa direção");
                    continue;
                }
                if (travelDate != birthDate) {
                    System.out.println("190");
                    continue;
                }
                System.out.printf("Passageiro %d seu assento é: %s. tenha um ótimo dia%n%n", i, seat);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}