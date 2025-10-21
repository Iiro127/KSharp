package org.example.Compiler;

import java.io.IOException;

public class Compiler {

    private static final ByteCodeEmitter emitter = new ByteCodeEmitter();
    public static void main(String[ ] args) {
        emitter.emitPrint("print hello//");
    }
}
