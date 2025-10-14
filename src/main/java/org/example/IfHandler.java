package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.example.InputReader.integers;
import static org.example.InputReader.strings;
public class IfHandler {
    private static final Map<String, String> conditionStr = new HashMap<>();
    private static final Map<String, Integer> conditionInt = new HashMap<>();
    private static final InputReader inputReader = new InputReader();
    private static String line;

    public void handleIf(String input){
        line = input;
        String condition = parseCondition(line);
        handleCondition(condition);
    }
    private String parseCondition(String line){
        String[] parts = line.split("\\(");
        String[] parts2 = parts[1].split("\\)");

        return parts2[0];
    }
    private String parseBody(String line){
        String[] parts = line.split("\\{");

        return parts[1].replace("}", "").trim();
    }
    private void handleCondition(String condition){
        if (condition.contains("=")){
            String[] parts = condition.split("=");
            String var = parts[0].trim();

            try {
                Integer value = Integer.parseInt(parts[1].replace("=", "").trim());
                conditionInt.put(var, value);
            } catch (Exception e){
                String value = parts[1].replace("=", "").trim();
                conditionStr.put(var, value);
            }

            if (integers.containsKey(var)){
                int stored = integers.get(var);
                int expected = conditionInt.get(var);

                if (stored == expected){
                    inputReader.readInput(parseBody(line));
                }
            } else if (strings.containsKey(var)) {
                String stored = strings.get(var);
                String expected = conditionStr.get(var);

                if (stored.equals(expected)){
                    inputReader.readInput(parseBody(line));
                }
            } else {
                System.out.println("false");
            }
        }
    }
}
