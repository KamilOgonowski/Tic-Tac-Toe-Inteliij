package com.kamil.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {

    static Scanner scanner = new Scanner(System.in);

    public static String getInput(String prompt){
        System.out.println(prompt + ": ");
        return scanner.next();
    }

    public static int getInputInt(String prompt) {
        int number = -1; // add check if returend value == -1 -> close the game
        int attempts = 3;
        for (int attempt = 1; attempt <= attempts; attempt++) {
            if (attempt == 2) {
                System.out.println("Try once again");
            }
            if (attempt == 3) {
                System.out.println("This is you last chance. If you do not provide correct value the game will be finished and you will lose!");
            }
            System.out.println(prompt + ": ");
            try {
                number = scanner.nextInt();
                if (number < 1) {
                    System.out.println("The provided value cannot be less than 1! ");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("The value you have provided is not a whole number!");
                scanner.hasNextLine();
            } catch (Exception e) {
                System.out.println("Something went wrong!");
                e.printStackTrace();
            }
        }
        return number;
    }


    public static int getInputInt(String prompt, int limit){
        System.out.println(prompt + ": ");
        return scanner.nextInt();
    }



}
