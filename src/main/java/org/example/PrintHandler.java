package org.example;

import static org.example.InputReader.integers;
import static org.example.InputReader.strings;

public class PrintHandler {
    public void handlePrint(String line){
        String expr = line.replace("print", "").trim();

        if (integers.containsKey(expr)){
            System.out.println(integers.get(expr));
        } else if (strings.containsKey(expr)) {
            System.out.println(strings.get(expr));
        } else {
            System.out.println(expr);
        }
    }
}
