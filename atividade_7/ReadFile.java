package atividade_7;

import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        try {
            List<String> lines = readLines("atividade_7/strings.txt");
            List<Integer> vogais = new ArrayList<>(List.of(0, 0, 0, 0, 0));
            int totalWords = 0;
            int lineExistsCAO = -1;
            String longestWord = "";
            String[] words;
            for (int i = 0; i < lines.size(); i++) {
                words = lines.get(i).toLowerCase().split(" ");
                for (String word : words) {
                    totalWords = countVowelsAndWords(vogais, word);
                    if (word.length() > longestWord.length()) {
                        longestWord = word;
                    }
                    if (lineExistsCAO == -1 && existsCAO(word)) {
                        lineExistsCAO = i + 1;
                    }
                }
            }
            System.out.printf("Existem %d palavras no texto.%n", totalWords);
            System.out.printf("A palavra %s possui %d caracteres é a mais longa%n", longestWord, longestWord.length());
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
        for (int i = 0; i < word.length(); i++) {
            var index = "aeiou".indexOf(word.charAt(i));
            if (index != -1) vogais.set(index, vogais.get(index) + 1);
        }
        return totalWords++;
    }

    static Boolean existsCAO(String word) {
        return word.contains("ção");
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