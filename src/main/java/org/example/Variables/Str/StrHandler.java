package org.example.Variables.Str;

import static org.example.App.errorReset;
import static org.example.App.errorText;
import static org.example.InputReader.strings;

public class StrHandler {
    public void handleStr(String line){
        if (line.contains("=")){
            String[] parts = line.split("=");
            String name = parts[0].replace("str", "").trim();
            String value = parts[1].replace("=", "").trim();
            if (name.contains(" ")){
                System.out.println(errorText + "Error at \"" + line + "\": Cannot include spaces in variable names." + errorReset);
            } else {
                strings.put(name, value);
            }
        } else if (line.contains("+")){
            String[] parts = line.split("\\+");
            String str1 = parts[0].replace("str", "").trim();
            String str2 = parts[1].trim();

            if (strings.containsKey(str1) && strings.containsKey(str2)){
                System.out.println(strings.get(str1) + strings.get(str2));
            }
        } else {
            System.out.println("Unknown command: " + line);
        }
    }
}
