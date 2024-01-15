package com.kamil.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {

    static Scanner scanner = new Scanner(System.in);

    public static String getInput(String prompt){
        System.out.println(prompt + ": ");
        return scanner.next();
    }

    public static int getInputInt(String prompt, int limit) {
        int number = -1; // add check if returned value == -1 -> close the game
        int attempts = 3;
        int attempt;
        for (attempt = 1; attempt <= attempts; attempt++) {
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
                if (number > limit){
                    System.out.println("The provided value is greater the the limit! ");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("The value you have provided is not a whole number!");
                scanner.nextLine();
                if(attempt!=3){
                    continue;
                }else
                    return -1;
            } catch (Exception e) {
                System.out.println("Something went wrong!");
                e.printStackTrace();
                if(attempt!=3){
                    continue;
                }else
                    return -1;
            }
            break;
        }
        return number;
    }



    public static int getInputInt(String prompt) {
        int number = -1; // add check if returned value == -1 -> close the game
        int attempts = 3;
        int attempt;
        for (attempt = 1; attempt <= attempts; attempt++) {
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
                scanner.nextLine();
                if(attempt!=3){
                    continue;
                }else
                    return -1;
            } catch (Exception e) {
                System.out.println("Something went wrong!");
                e.printStackTrace();
                if(attempt!=3){
                    continue;
                }else
                    return -1;
            }
            break;
        }
        return number;
    }
}
