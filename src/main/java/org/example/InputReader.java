package org.example;

import java.util.HashMap;
import java.util.Map;

public class InputReader {
    public static Map<String, String> strings = new HashMap<>();
    public static Map<String, Integer> integers = new HashMap<>();
    private static final VariableHandler variableHandler = new VariableHandler();
    private static final PrintHandler printHandler = new PrintHandler();
    private static final IfHandler ifHandler = new IfHandler();
    public void readInput(String line){
        switch (line) {
            case String s when s.startsWith("let") -> variableHandler.handleLet(s);
            case String s when s.startsWith("print") -> printHandler.handlePrint(s);
            case String s when s.startsWith("when") -> ifHandler.handleIf(s);
            default -> System.out.println("Unknown command: " + line);
        };
    }
}
