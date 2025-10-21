package org.example;

import static jdk.internal.org.objectweb.asm.Opcodes.GETSTATIC;
import static jdk.internal.org.objectweb.asm.Opcodes.INVOKEVIRTUAL;
import static org.example.Compiler.ByteCodeResource.mv;
import static org.example.InputReader.integers;
import static org.example.InputReader.strings;

public class PrintHandler {

    /**
     * Handles all printing.
     *
     * @param line
     */
    public void handlePrint(String line){
        String expr = line.replace("print", "").trim();

        if (expr.contains("//")){
            emitPrint(expr.replace("//", ""));
        } else {
            emitPrint(getVariable(expr));
        }
    }

    public void emitPrint(String line) {
        String expr = line.replace("print", "").replace("//", "").trim();

        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitLdcInsn(expr);
        mv.visitMethodInsn(INVOKEVIRTUAL,
                "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
    }

    /**
     * Gets a referenced variable.
     *
     * @param expr
     */
    private String getVariable(String expr){
        if (integers.containsKey(expr)){
            return integers.get(expr).toString();
        } else if (strings.containsKey(expr)) {
            return strings.get(expr);
        } else {
            throw new NullPointerException();
        }
    }
}
