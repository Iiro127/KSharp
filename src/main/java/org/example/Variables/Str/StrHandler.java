package org.example.Variables.Str;

import static org.example.InputReader.strings;

public class StrHandler {
    public void handleStr(String line){
        String[] parts = line.split("=");
        String name = parts[0].replace("str", "").trim();
        String value = parts[1].replace("=", "").trim();
        strings.put(name, value);
    }
}
