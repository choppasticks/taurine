package me.choppa.taurine.ui;

import me.choppa.taurine.core.Taurine;

import javax.swing.*;
import java.awt.*;

public class EditorPanel extends JPanel {
    private Font font = new Font("Monospaced", Font.PLAIN, 16);
    private Color backgroundColor = new Color(Color.GRAY.getRGB());
    private Color foregroundColor = new Color(Color.WHITE.getRGB());

    private int lineHeight = 18;

    private int distanceFromTop = 20;
    private int distanceFromLeft = 10;

    private final Taurine taurine = Taurine.getInstance();

    public EditorPanel() {
        this.setLayout(new BorderLayout());
        this.setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(font);
        setBackground(backgroundColor);
        setForeground(foregroundColor);

        int textY = distanceFromTop;

        FontMetrics metrics = g.getFontMetrics();

        for (StringBuilder stringBuilder : taurine.getBufferHandler().getLines()) {
            g.drawString(stringBuilder.toString(), distanceFromLeft, textY);
            textY += lineHeight;
        }

        int charWidth = metrics.charWidth('m');

        int cursorX = distanceFromLeft + taurine.getBufferHandler().getCursorColumn() * charWidth;
        int cursorY = distanceFromTop + taurine.getBufferHandler().getCursorRow() * lineHeight;

        g.drawLine(cursorX, cursorY - metrics.getAscent(), cursorX, cursorY + metrics.getDescent());
    }
}
