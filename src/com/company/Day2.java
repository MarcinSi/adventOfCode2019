package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
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
                table[i] = Integer.parseInt(token);
                i++;
            }
//
            table[1] = 12;
            table[2] = 2;
            int [] output = new int[table.length];
            for (int j = 0; j < table.length; j = j + 4) {

                if (table[j] == 1) {
                    table[table[j+3]] = (table [table[j+1]] + table [table[j+2]]);
                }
                if (table[j] == 2) {
                    table[table[j+3]] = (table [table[j+1]] * table [table[j+2]]);
                }
                if (table[j] == 99) {
                    System.out.println("kod 99");
                    break;
                }
            }
            System.out.println("Odpowiedź: " + table[0]);
        } catch (FileNotFoundException e) {
            System.out.println("Plik nie został znaleziony!");
        }
    }
}
