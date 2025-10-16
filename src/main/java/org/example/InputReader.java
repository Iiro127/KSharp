package org.example;

import org.example.Variables.Num.NumHandler;
import org.example.Variables.Str.StrHandler;
import org.example.whenHandler.WhenHandler;

import java.util.HashMap;
import java.util.Map;

import static org.example.KSharpConsole.errorReset;
import static org.example.KSharpConsole.errorText;

public class InputReader {
    public static Map<String, String> strings = new HashMap<>();
    public static Map<String, Integer> integers = new HashMap<>();
    private static final NumHandler numHandler = new NumHandler();
    private static final StrHandler strHandler = new StrHandler();
    private static final PrintHandler printHandler = new PrintHandler();
    private static final WhenHandler whenHandler = new WhenHandler();

    /**
     * Reads console input.
     *
     * @param line
     */
    public String readInput(String line){
        //TODO: Add more runtime error handling when needed.
        try {
            switch (line) {
                case String s when s.startsWith("num") -> {
                    return numHandler.handleNum(s);
                }
                case String s when s.startsWith("str") -> {
                    return strHandler.handleStr(s);
                }
                case String s when s.startsWith("print") -> {
                    return  printHandler.handlePrint(s);
                }
                case String s when s.startsWith("when") -> {
                    return whenHandler.handleWhen(s);
                }
                default -> {
                    return "Unknown command: " + line;
                }
            }
        } catch (NumberFormatException e){
            return errorText + "Error at \"" + line + "\": Cannot define num as str-value." + errorReset;
        } catch (NullPointerException e){
            return errorText + "Error at \"" + line + "\": Cannot reference a non-existent variable." + errorReset;
        }
    }
}
