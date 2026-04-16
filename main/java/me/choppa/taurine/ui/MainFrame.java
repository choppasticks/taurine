package me.choppa.taurine.ui;

import me.choppa.taurine.core.Taurine;
import me.choppa.taurine.keys.KeyInput;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    private EditorPanel editorPanel;

    public void build() {
        JFrame frame = new JFrame("Taurine");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        editorPanel = new EditorPanel();
        frame.add(editorPanel);

        frame.addKeyListener(new KeyInput());
    }

    public EditorPanel getEditorPanel() {
        return editorPanel;
    }
}
