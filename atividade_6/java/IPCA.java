package atividade_6.java;

import java.util.ArrayList;
import java.util.Scanner;

public class IPCA {
    public static void main(String[] args) {
        // entrada ano mes indice
        try (var scan = new Scanner(System.in)) {
            var entrada = "";
            var info = new ArrayList<String>();
            do {
                System.out.print("Digite as informações: (* para parar) ");
                entrada = scan.nextLine();
                info.add(entrada);
            } while (!entrada.equals("*"));
            
            var formatado = info.stream()
            .limit(info.size() - 1)
            .map(value -> value.split(" "))
            .map(s -> Double.valueOf(s[2]))
            .sorted()
            .toList();
            var soma = 0;
            for (Double s : formatado) {
                soma += s;
            }
            
            System.out.println("maior: " + info.get(formatado.indexOf(formatado.getFirst())));
            System.out.println("menor: " + info.get(formatado.indexOf(formatado.getLast())));
            System.out.println("média: " + soma / formatado.size());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}