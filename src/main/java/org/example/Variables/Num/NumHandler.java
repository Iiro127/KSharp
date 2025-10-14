package org.example.Variables.Num;

import static org.example.InputReader.integers;

public class NumHandler {
    public void handleNum(String line){
        String[] parts = line.split("=");
        String name = parts[0].replace("num", "").trim();
        Integer value = Integer.parseInt(parts[1].replace("=", "").trim());
        integers.put(name, value);
    }
}
