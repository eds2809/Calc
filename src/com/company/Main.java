package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        greeting();


        Scanner scanner = new Scanner(System.in);

        while (true){
            String command = "";
            System.out.print("enter expression: ");
            if (scanner.hasNext()){
                command = scanner.next();

                if (command.equalsIgnoreCase("exit")){
                    break;
                }
            }

            Calc calc = new Calc(command);
            calc.verification();
            System.out.println("result: "+ calc.result()+"\n");
        }
    }

    private static void greeting() {
        System.out.print("the calculator supports the following operations: ");
        for(Enum e : OperationType.values()){
            System.out.print(" " + e);
        }

        System.out.println("\nto exit \"EXIT\" \n");
    }
}
