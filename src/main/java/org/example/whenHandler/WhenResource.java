package org.example.whenHandler;

public class WhenResource {
    public String parseCondition(String line){
        String[] parts = line.split("\\(");
        String[] parts2 = parts[1].split("\\)");

        return parts2[0];
    }
    public String parseBody(String line){
        String[] parts = line.split("\\{");

        return parts[1].replace("}", "").trim();
    }
}
