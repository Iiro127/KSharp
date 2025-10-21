package org.example;

import java.io.IOException;
import java.util.Scanner;

public class KSharpConsole
{
    private static final InputReader inputReader = new InputReader();
    public static final String errorText = "\u001B[31m";
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

            //TODO: Add more runtime error handling when needed.
            try {
                inputReader.readInput(line);
            } catch (NumberFormatException e){
                System.out.println(errorText + "Error at \"" + line + "\": Cannot define num as str-value." + errorReset);
            } catch (NullPointerException e){
                System.out.println(errorText + "Error at \"" + line + "\": Cannot reference a non-existent variable." + errorReset);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
