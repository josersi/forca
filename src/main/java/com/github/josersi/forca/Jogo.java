package com.github.josersi.forca;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Jogo {
    public static void main(String[] args) {
        System.out.println("<<< Jogo da Forca (digite \"quit\" para sair) >>>");

        InputStream palavrasIstream = Jogo.class.getClassLoader().getResourceAsStream("palavras.txt");

        List<String> palavras = new BufferedReader(new InputStreamReader(palavrasIstream))
                .lines().parallel().map(palavra -> palavra.toUpperCase()).collect(Collectors.toList());

        Scanner scanner = new Scanner(System.in);

        boolean jogando = true;

        while(jogando) {
            String palavra = palavras.get(new Random().nextInt(palavras.size()));

            char[] placeholders =  palavra.replaceAll(".", "_").toCharArray();

            Set<Character> erros = new HashSet<>();

            while (erros.size() < 6) {
                System.out.println(Hangman.get(erros.size(), new String(placeholders).replaceAll("(.)", "$1 ")));

                System.out.print(">>> ");
                String tentativa = scanner.next().toUpperCase();

                if (tentativa.equals("QUIT")) {
                    System.exit(0);
                }

                if (palavra.contains(tentativa)) {
                    for (int i = 0; i < palavra.length(); ++i) {
                        if (palavra.charAt(i) == tentativa.charAt(0)) {
                            placeholders[i] = palavra.charAt(i);
                        }
                    }

                    if (palavra.equals(new String(placeholders))) {
                        break;
                    }
                } else {
                    erros.add(tentativa.charAt(0));
                }
            }

            if (erros.size() == 6) {
                System.out.println(Hangman.get(erros.size(), new String(placeholders).replaceAll("(.)", "$1 ")));
                System.out.println("<<< Você perdeu!! A palavra era " + palavra);
            } else {
                System.out.println("<<< Você ganhou!! A palavra era " + palavra);
            }

            System.out.print("\n>>> Deseja jogar novamente? (s/n) ");

            String next = scanner.next().toUpperCase();

            if ("N".equals(next)) {
                jogando = false;
            }
        }
    }
}
