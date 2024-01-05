package com.kamil.util;

import java.util.Scanner;

public class Console {

    static Scanner scanner = new Scanner(System.in);

    public static String getInput(String prompt){
        System.out.println(prompt + ": ");
        return scanner.next();
    }

    public static int getInputInt(String prompt){
        System.out.println(prompt + ": ");
        return scanner.nextInt();
    }



}
