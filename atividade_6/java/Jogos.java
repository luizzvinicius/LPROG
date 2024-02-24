package atividade_6.java;

import java.util.Scanner;

public class Jogos {
    public static void main(String[] args) {
        try (var scan = new Scanner(System.in)) {
            System.out.print("Quantos jogos foram vendidos? ");
            var JOGOS_VENDIDOS = scan.nextInt();
            final double VALOR_JOGO = 19.9;
            var total = JOGOS_VENDIDOS * VALOR_JOGO;
            var bonus = JOGOS_VENDIDOS / 15 > 0 ? total * (JOGOS_VENDIDOS / 15 * 0.08) : 0;
            var salarioCatarina = total / 2 + bonus;
            System.out.printf("%.2f %n%.2f %n%.2f", total, bonus, salarioCatarina);
        } catch (Exception e) {
            System.out.println(e);
        }
    }   
}