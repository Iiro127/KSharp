package org.example.Variables.Num;

import static org.example.InputReader.integers;

public class NumHandler {
    private static final MathHandler mathHandler = new MathHandler();
    public void handleNum(String line){
        if (line.contains("=")){
            String[] parts = line.split("=");
            String name = parts[0].replace("num", "").trim();
            Integer value = Integer.parseInt(parts[1].replace("=", "").trim());
            integers.put(name, value);
        } else if (line.contains("+")) {
            mathHandler.addition(line);
        } else if (line.contains("-")) {
            mathHandler.subtraction(line);
        }
    }
}
