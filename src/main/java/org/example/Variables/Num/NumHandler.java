package org.example.Variables.Num;

import static org.example.InputReader.integers;

public class NumHandler {
    public void handleNum(String line){
        if (line.contains("=")){
            String[] parts = line.split("=");
            String name = parts[0].replace("num", "").trim();
            Integer value = Integer.parseInt(parts[1].replace("=", "").trim());
            integers.put(name, value);
        } else if (line.contains("+")) {
            String[] parts = line.split("\\+");
            String num1 = parts[0].replace("num", "").trim();
            String num2 = parts[1].trim();

            if (integers.containsKey(num1) && integers.containsKey(num2)){
                System.out.println(integers.get(num1) + integers.get(num2));
            }
        } else if (line.contains("-")) {
            String[] parts = line.split("\\-");
            String num1 = parts[0].replace("num", "").trim();
            String num2 = parts[1].trim();

            if (integers.containsKey(num1) && integers.containsKey(num2)){
                System.out.println(integers.get(num1) - integers.get(num2));
            }
        }
    }
}
