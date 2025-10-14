package org.example;

import org.example.whenHandler.WhenHandler;

import java.util.HashMap;
import java.util.Map;

public class InputReader {
    public static Map<String, String> strings = new HashMap<>();
    public static Map<String, Integer> integers = new HashMap<>();
    private static final VariableHandler variableHandler = new VariableHandler();
    private static final PrintHandler printHandler = new PrintHandler();
    private static final WhenHandler whenHandler = new WhenHandler();
    public void readInput(String line){
        switch (line) {
            case String s when s.startsWith("let") -> variableHandler.handleLet(s);
            case String s when s.startsWith("print") -> printHandler.handlePrint(s);
            case String s when s.startsWith("when") -> whenHandler.handleWhen(s);
            default -> System.out.println("Unknown command: " + line);
        };
    }
}
