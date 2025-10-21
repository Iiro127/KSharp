package org.example.Compiler;

import org.example.InputReader;

import java.io.IOException;

public class Compiler {
    private static final InputReader inputReader = new InputReader();
    public static void main(String[ ] args) throws IOException {
        inputReader.readInput("print hello world//;");
    }
}
