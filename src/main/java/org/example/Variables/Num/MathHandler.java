package org.example.Variables.Num;

import static org.example.InputReader.integers;

public class MathHandler {
    public void addition(String line){
        String[] parts = line.split("\\+");
        String num1 = parts[0].replace("num", "").trim();
        String num2 = parts[1].trim();

        if (integers.containsKey(num1) && integers.containsKey(num2)){
            System.out.println(integers.get(num1) + integers.get(num2));
        }
    }

    public void subtraction(String line) {
        String[] parts = line.split("\\-");
        String num1 = parts[0].replace("num", "").trim();
        String num2 = parts[1].trim();

        if (integers.containsKey(num1) && integers.containsKey(num2)){
            System.out.println(integers.get(num1) - integers.get(num2));
        }
    }
}
