package org.example.Variables.Num;

import org.example.Variables.VarResource;

import static org.example.KSharpConsole.errorReset;
import static org.example.KSharpConsole.errorText;
import static org.example.InputReader.integers;

public class NumHandler {
    private static final MathHandler mathHandler = new MathHandler();
    private static final VarResource varResource = new VarResource();

    /**
     * Handles num-variables.
     *
     * @param line
     */
    public String handleNum(String line){
        if (line.contains("=")){
            String[] parts = line.split("=");
            String name = parts[0].replace("num", "").trim();

            if (!varResource.isValidName(name)){
                return errorText + "Error at \"" + line + "\": Not a valid name." + errorReset;
            } else {
                Integer value = Integer.parseInt(parts[1].replace("=", "").trim());
                integers.put(name, value);
            }
        } else if (line.contains("+")) {
            return mathHandler.addition(line).toString();
        } else if (line.contains("-")) {
            return mathHandler.subtraction(line).toString();
        }

        return "";
    }
}
