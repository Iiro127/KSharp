package org.example;

import org.example.Variables.Num.NumHandler;
import org.example.Variables.Str.StrHandler;
import org.example.whenHandler.WhenHandler;

import java.util.ArrayList;
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

    public ArrayList<String> parseLines(String input) {
        ArrayList<String> lines = new ArrayList<>();
        StringBuilder instruction = new StringBuilder();

        for (char letter : input.toCharArray()) {
            if (letter == ';') {
                lines.add(instruction.toString().trim());
                instruction.setLength(0);
            } else {
                instruction.append(letter);
            }
        }

        if (!instruction.isEmpty()) {
            lines.add(instruction.toString().trim());
        }

        return lines;
    }


    /**
     * Reads console input.
     *
     * @param input
     */
    public String readInput(String input) {
        StringBuilder output = new StringBuilder();

        for (String line : parseLines(input)) {
            try {
                String result = switch (line) {
                    case String s when s.startsWith("num") -> numHandler.handleNum(s);
                    case String s when s.startsWith("str") -> strHandler.handleStr(s);
                    case String s when s.startsWith("print") -> printHandler.handlePrint(s);
                    case String s when s.startsWith("when") -> whenHandler.handleWhen(s);
                    default -> "Unknown command: " + line;
                };

                if (!result.isBlank()) {
                    output.append(result).append("\n");
                }

            } catch (NumberFormatException e) {
                output.append(errorText)
                        .append("Error at \"").append(line)
                        .append("\": Cannot define num as str-value.")
                        .append(errorReset).append("\n");
            } catch (NullPointerException e) {
                output.append(errorText)
                        .append("Error at \"").append(line)
                        .append("\": Cannot reference a non-existent variable.")
                        .append(errorReset).append("\n");
            }
        }

        return output.toString().trim();
    }

}
