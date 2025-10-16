package ksharp.ide;

import org.example.InputReader;

import javax.swing.*;
import java.awt.*;

public class KSharpIDE {
    private static final InputReader inputReader = new InputReader();
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("K# IDE");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 500);
            frame.setLayout(new BorderLayout());

            JTextArea editor = new JTextArea();
            JTextArea console = new JTextArea();
            console.setEditable(false);

            JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                    new JScrollPane(editor),
                    new JScrollPane(console));
            splitPane.setResizeWeight(0.7);

            JButton runButton = new JButton("Run");
            runButton.addActionListener(e -> {
                String code = editor.getText();
                console.setText(inputReader.readInput(code));
            });

            frame.add(splitPane, BorderLayout.CENTER);
            frame.add(runButton, BorderLayout.SOUTH);

            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
