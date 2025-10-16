package org.example;

import static org.example.InputReader.integers;
import static org.example.InputReader.strings;

public class PrintHandler {

    /**
     * Handles all printing.
     *
     * @param line
     */
    public void handlePrint(String line){
        String expr = line.replace("print", "").trim();

        if (expr.contains("//")){
            System.out.println(expr.replace("//", ""));
        } else {
            getVariable(expr);
        }
    }

    /**
     * Gets a referenced variable.
     *
     * @param expr
     */
    private void getVariable(String expr){
        if (integers.containsKey(expr)){
            System.out.println(integers.get(expr));
        } else if (strings.containsKey(expr)) {
            System.out.println(strings.get(expr));
        } else {
            throw new NullPointerException();
        }
    }
}
