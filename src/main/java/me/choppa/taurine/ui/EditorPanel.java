package me.choppa.taurine.ui;

import java.awt.BorderLayout;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JPanel;
import me.choppa.taurine.core.Taurine;
import me.choppa.taurine.editor.BufferHandler;
import me.choppa.taurine.input.InputManager;
import me.choppa.taurine.ui.components.PanelComponent;

public class EditorPanel extends JPanel {

    private final PanelComponent panelComponent;

    public EditorPanel() {
        panelComponent = new PanelComponent(this);
        this.setLayout(new BorderLayout());
        this.requestFocusInWindow();
        this.setFocusable(true);
        this.addKeyListener(new InputManager());
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        FontMetrics fontMetrics = graphics.getFontMetrics();
        TabHandler tabHandler = Taurine.getInstance().getTabHandler();
        BufferHandler bufferHandler = tabHandler.getActiveTab();
        panelComponent.drawPanel(
            graphics,
            tabHandler,
            fontMetrics,
            bufferHandler
        );
    }
}
