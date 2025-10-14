package org.example;

import java.util.Scanner;

public class App 
{
    private static final InputReader inputReader = new InputReader();
    private static final String errorText = "\u001B[31m";
    public static final String errorReset = "\u001B[0m";


    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);

        System.out.println("K# console. Type 'exit' to quit.");

        while (true) {
            System.out.print(">>> ");
            String line = input.nextLine().trim();

            if (line.equals("exit")){
                break;
            }

            //TODO: Add more error handling when needed.
            try {
                inputReader.readInput(line);
            } catch (NumberFormatException e){
                System.out.println(errorText + "Error at \"" + line + "\": Cannot define num as str-value." + errorReset);
            }
        }
    }
}
