package org.example;

import static org.example.InputReader.integers;
import static org.example.InputReader.strings;

public class PrintHandler {

    /**
     * Handles all printing.
     *
     * @param line
     */
    public String handlePrint(String line){
        String expr = line.replace("print", "").trim();

        if (expr.contains("//")){
            return expr.replace("//", "");
        } else {
            return getVariable(expr);
        }
    }

    /**
     * Gets a referenced variable.
     *
     * @param expr
     */
    private String getVariable(String expr){
        if (integers.containsKey(expr)){
            return integers.get(expr).toString();
        } else if (strings.containsKey(expr)) {
            return strings.get(expr);
        } else {
            throw new NullPointerException();
        }
    }
}
