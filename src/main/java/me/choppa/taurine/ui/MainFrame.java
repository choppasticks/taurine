package me.choppa.taurine.ui;

import javax.swing.*;
import me.choppa.taurine.core.Taurine;

public class MainFrame {

    private EditorPanel editorPanel;

    public void build() {
        JFrame frame = new JFrame(Taurine.NAME);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        editorPanel = new EditorPanel();
        frame.add(editorPanel);
    }

    public EditorPanel getEditorPanel() {
        return editorPanel;
    }
}
