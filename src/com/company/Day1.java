package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {

    public static void day1() {


        double moduleMass;
        double fuelForModule;
        double fuelForFuel = 0;
        double sumOfFuel = 0;

        File file = new File("c:/puzzle.txt");

        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                moduleMass = Double.parseDouble(scan.nextLine());
                fuelForModule = Math.floor(moduleMass / 3) - 2;
                sumOfFuel = sumOfFuel + fuelForModule;
                System.out.println("Masa modułu: " + moduleMass + " ==> masa paliwa: " + fuelForModule);
                // obliczanie potrzebnego paliwa dla masy samego paliwa
                while ((Math.floor(fuelForModule / 3) - 2) >= 0) {
                    fuelForModule = Math.floor(fuelForModule / 3) - 2;
                    sumOfFuel = sumOfFuel + fuelForModule;

                }
            }
        } catch (FileNotFoundException e)

        {
            System.out.println("Koniec danych");
        }
        System.out.println("Wynik końcowy: " + (int) sumOfFuel);
    }
}
