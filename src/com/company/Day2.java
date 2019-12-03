package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Day2 {

    public static void day2() {

        File file = new File("c:/puzzle2.txt");
        // budowanie tablicy z liczb trzymanych w pliku
        try {
            Scanner scan = new Scanner(file);
            String string = scan.nextLine();
            System.out.println(string);

            StringTokenizer tokenizer = new StringTokenizer(string, ",");
            System.out.println("Intcode ma " + tokenizer.countTokens() + " pozycji");
            String token;
            int[] table = new int[tokenizer.countTokens()];
            int i = 0;
            while (tokenizer.hasMoreTokens()) {
                token = tokenizer.nextToken();
                //  System.out.println(token);
                table[i] = Integer.parseInt(token);
                i++;
            }

            // algorytm komputera
            for (int j = 0; j <= table.length - 2; j = j + 4) {
                System.out.println(table[j] + ", " + table[j + 1] + ", " + table[j + 2] + ", " + table[j + 3]);
            }
            System.out.println("Tabela zmieniona: ");
            table[1] = 12;
            table[2] = 2;
            for (int j = 0; j < table.length; j = j + 4) {

                if (table[j] == 1) {
                    table[j + 3] = table[j + 1] + table[j + 2];
                }
                if (table[j] == 2) {
                    table[j + 3] = table[j + 1] * table[j + 2];
                }
                if (table[j] == 99) {
                    System.out.println("kod 99");
                    break;
                }
                System.out.println(table[j] + ", " + table[j + 1] + ", " + table[j + 2] + ", " + table[j + 3]);
            }
            System.out.println("Odpowiedź: " + table[0]);
        } catch (FileNotFoundException e) {
            System.out.println("Plik nie został znaleziony!");
        }
    }
}
