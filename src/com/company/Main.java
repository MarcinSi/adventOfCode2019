package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        double moduleMass;
        double fuelForModule;
        double sumOfFuel = 0;

        File file = new File("c:/puzzle.txt");
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                moduleMass = Double.parseDouble(scan.nextLine());

                fuelForModule = Math.floor(moduleMass / 3) - 2;
                sumOfFuel = sumOfFuel + fuelForModule;
                System.out.println("Masa modułu: " + moduleMass + " ==> masa paliwa: "+ fuelForModule);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Koniec danych");
        }
        System.out.println("Wynik końcowy: " + (int)sumOfFuel);
    }


}
