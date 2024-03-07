package atividade_7;

import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class ReadFile {
    static List<Integer> vogais = new ArrayList<>(List.of(0, 0, 0, 0, 0));
    static int totalWords = 0;

    public static void main(String[] args) {
        try {
            List<String> lines = readLines("atividade_7/strings.txt");
            int qtdLines = lines.size();
            int lineExistsCAO = -1;
            String[] words;
            Object[] longestWord = { "", 0 };
            for (var i = 0; i < qtdLines; i++) {
                words = lines.get(i).split(" ");
                for (String word : words) {
                    countVowelsAndWords(word);
                    if (word.length() > Integer.parseInt(longestWord[1].toString())) {
                        longestWord[0] = word;
                        longestWord[1] = word.length();
                    }
                    boolean exists = existsCAO(word);
                    if (lineExistsCAO == -1 && exists) {
                        lineExistsCAO = i + 1;
                    }
                }
            }
            System.out.printf("Existem %d palavras no texto.%n", totalWords);
            System.out.printf("A palavra %s possui %d caracteres é a mais longa%n", longestWord[0], longestWord[1]);
            System.out.printf("Vogal mais recorrente: %s%n", recurrentVowel());
            System.out.printf("1º Ocorrência de 'ção' é na %d linha%n", lineExistsCAO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static List<String> readLines(String path) throws IOException {
        return Files.readAllLines(Paths.get(path));
    }

    static void countVowelsAndWords(String word) {
        word.toLowerCase().chars()
        .forEach(c -> {
            var index = "aeiou".indexOf(c);
            if (index != -1) vogais.set(index, vogais.get(index) + 1);
        });
        totalWords++;
    }

    static Boolean existsCAO(String word) {
        return word.toLowerCase().contains("ção");
    }

    static String recurrentVowel() {
        var index = vogais.indexOf(Collections.max(vogais));
        return switch (index) {
            case 0 -> "a";
            case 1 -> "e";
            case 2 -> "i";
            case 3 -> "o";
            case 4 -> "u";
            default -> "None";
        };
    }
}