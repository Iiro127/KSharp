package org.example.Compiler;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static jdk.internal.org.objectweb.asm.Opcodes.*;

public class ByteCodeEmitter {
    private final ClassWriter cw;
    public static MethodVisitor mv = null;

    public ByteCodeEmitter() {
        cw = new ClassWriter(0);
        cw.visit(V17, ACC_PUBLIC, "KSharp", null, "java/lang/Object", null);

        mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V",  null, null);
        mv.visitCode();
    }

    public void emitPrint(String line) {
        String expr = line.replace("print", "").replace("//", "").trim();

        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitLdcInsn(expr);
        mv.visitMethodInsn(INVOKEVIRTUAL,
                "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
    }
    public void finishClass(String outputName) {
        mv.visitInsn(RETURN);
        mv.visitMaxs(2, 1);
        mv.visitEnd();
        cw.visitEnd();

        byte[] bytes = cw.toByteArray();
        try {
            Files.write(Path.of(outputName), bytes);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
