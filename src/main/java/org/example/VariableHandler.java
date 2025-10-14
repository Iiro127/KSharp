package org.example;

import static org.example.InputReader.integers;
import static org.example.InputReader.strings;

public class VariableHandler {
    public void handleLet(String line){
        String[] parts = line.split("=");
        String name = parts[0].replace("let", "").trim();
        try {
            Integer value = Integer.parseInt(parts[1].trim());
            integers.put(name, value);
        } catch (Exception e){
            String value = parts[1].trim();
            strings.put(name, value);
        }
    }
}
