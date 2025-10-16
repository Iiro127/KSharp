package org.example.Variables;

public class VarResource {
    /**
     * Checks if a name is valid (no spaces or special characters).
     *
     * @param name
     * @return
     */
    public boolean isValidName(String name){
        return !name.contains(" ") && !name.matches("[a-zA-Z0-9]*");
    }
}
