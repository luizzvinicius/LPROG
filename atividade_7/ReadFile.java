package atividade_7;

import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        try {
            List<Integer> vogais = new ArrayList<>(List.of(0, 0, 0, 0, 0));
            List<String> lines = readLines("atividade_7/strings.txt");
            int lineExistsCAO = -1;
            String[] words;
            Object[] longestWord = { "", 0 };
            int totalWords = 0;
            for (int i = 0; i < lines.size(); i++) {
                words = lines.get(i).split(" ");
                for (String word : words) {
                    totalWords = countVowelsAndWords(vogais, word);
                    if (word.length() > Integer.parseInt(longestWord[1].toString())) {
                        longestWord[0] = word;
                        longestWord[1] = word.length();
                    }
                    if (lineExistsCAO == -1 && existsCAO(word)) {
                        lineExistsCAO = i + 1;
                    }
                }
            }
            System.out.printf("Existem %d palavras no texto.%n", totalWords);
            System.out.printf("A palavra %s possui %d caracteres é a mais longa%n", longestWord[0], longestWord[1]);
            System.out.printf("Vogal mais recorrente: %s%n", recurrentVowel(vogais));
            System.out.printf("1º Ocorrência de 'ção' é na %d linha%n", lineExistsCAO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static List<String> readLines(String path) throws IOException {
        return Files.readAllLines(Paths.get(path));
    }

    static int countVowelsAndWords(List<Integer> vogais, String word) {
        int totalWords = 0;
        word.toLowerCase().chars()
        .forEach(c -> {
            var index = "aeiou".indexOf(c);
            if (index != -1) vogais.set(index, vogais.get(index) + 1);
        });
        return totalWords++;
    }

    static Boolean existsCAO(String word) {
        return word.toLowerCase().contains("ção");
    }

    static String recurrentVowel(List<Integer> vogais) {
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