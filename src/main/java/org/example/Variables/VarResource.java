package org.example.Variables;

public class VarResource {
    public boolean isValidName(String name){
        return !name.contains(" ") && !hasSpecialCharacters(name);
    }

    private boolean hasSpecialCharacters(String name) {
        return !name.matches("[a-zA-Z0-9]*");
    }
}
