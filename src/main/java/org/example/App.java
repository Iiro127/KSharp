package org.example;

import java.util.Scanner;

public class App 
{
    private static final InputReader inputReader = new InputReader();

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

            inputReader.readInput(line);
        }
    }
}
