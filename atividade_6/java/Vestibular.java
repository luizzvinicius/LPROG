package atividade_6.java;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Vestibular {
    public static void main(String[] args) {
        try (var scan = new Scanner(System.in)) {
            final String[] GABARITO = { "1", "5", "3", "2", "4", "2", "1", "2", "3", "5" };
            var candidatos = new ArrayList<ArrayList<String>>();
            var nome = "";
            var resposta = "";
            while (true) {
                System.out.print("Nome participante: ");
                nome = scan.nextLine();
                if (nome.equals("*"))
                    break;
                System.out.print("Notas do participante separadas por espaço: ");
                resposta = scan.nextLine();
                candidatos.add(new ArrayList<String>(List.of(nome, resposta)));
            }
            var nota = 0;
            for (var i = 0; i < candidatos.size(); i++) {
                for (var j = 0; j < GABARITO.length; j++) {
                    if (GABARITO[j].equals(candidatos.get(i).get(1).split(" ")[j])) {
                        nota++;
                    }
                }
                candidatos.get(i).add(Integer.toString(nota));
                nota = 0;
            }
            candidatos.sort((c1, c2) -> c1.get(0).compareTo(c2.get(0)));
            candidatos.forEach(c1 -> System.out.printf("%s %s%n", c1.get(0), c1.get(2)));
            candidatos.sort((c1, c2) -> c1.get(2).compareTo(c2.get(2)));
            System.out.printf("Menor nota: %s candidato: %s%n", candidatos.getLast().get(2),
                    candidatos.getLast().get(0));
            System.out.printf("Maior nota: %s candidato: %s%n", candidatos.getFirst().get(2),
                    candidatos.getFirst().get(0));
            var notasMiores5 = 0d;
            for (var i = 0; i < candidatos.size(); i++) {
                if (Integer.parseInt(candidatos.get(i).get(2)) > 5) {
                    notasMiores5++;
                }
            }
            System.out.printf("%.2f dos candidatos acima da média", notasMiores5 / candidatos.size() * 100);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}