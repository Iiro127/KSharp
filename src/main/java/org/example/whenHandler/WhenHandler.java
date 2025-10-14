package org.example.whenHandler;

import org.example.InputReader;

import java.util.HashMap;
import java.util.Map;

import static org.example.InputReader.integers;
import static org.example.InputReader.strings;
public class WhenHandler {
    public static final Map<String, String> conditionStr = new HashMap<>();
    public static final Map<String, Integer> conditionInt = new HashMap<>();
    private static final InputReader inputReader = new InputReader();
    private static final WhenResource whenHandler = new WhenResource();
    private static String line;

    public void handleWhen(String input){
        line = input;
        String condition = whenHandler.parseCondition(line);
        handleCondition(condition);
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
                    inputReader.readInput(whenHandler.parseBody(line));
                }
            } else if (strings.containsKey(var)) {
                String stored = strings.get(var);
                String expected = conditionStr.get(var);

                if (stored.equals(expected)){
                    inputReader.readInput(whenHandler.parseBody(line));
                }
            } else {
                System.out.println("false");
            }
        }
    }
}
