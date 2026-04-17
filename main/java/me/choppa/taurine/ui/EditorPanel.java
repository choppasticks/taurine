package me.choppa.taurine.ui;

import java.awt.*;
import javax.swing.*;
import me.choppa.taurine.core.Taurine;

public class EditorPanel extends JPanel {

    private Font font = new Font("Monospaced", Font.PLAIN, 16);
    private Color backgroundColor = new Color(75, 75, 150);
    private Color foregroundColor = new Color(Color.WHITE.getRGB());

    private final Taurine taurine = Taurine.getInstance();

    public EditorPanel() {
        this.setLayout(new BorderLayout());
        this.setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(font);

        FontMetrics fontMetrics = g.getFontMetrics();

        int lineHeight = fontMetrics.getHeight();

        setBackground(backgroundColor);
        setForeground(foregroundColor);

        int distanceFromTop = 20;
        int textY = distanceFromTop;

        int lineCount = 1;

        int gutterWidth = 30;
        for (StringBuilder stringBuilder : taurine
            .getBufferHandler()
            .getLines()) {
            g.drawString(stringBuilder.toString(), gutterWidth, textY);
            String lineNumb = String.format("%2d", lineCount);
            g.drawString(lineNumb, 2, textY);
            lineCount++;
            textY += lineHeight;
        }

        int cursorRow = taurine.getBufferHandler().getCursorRow();
        int cursorColumn = taurine.getBufferHandler().getCursorColumn();

        String currentLine = taurine
            .getBufferHandler()
            .getLines()
            .get(cursorRow)
            .toString();
        String beforeCursor = currentLine.substring(
            0,
            Math.min(cursorColumn, currentLine.length())
        );

        int cursorX = gutterWidth + fontMetrics.stringWidth(beforeCursor);
        int cursorYTop = distanceFromTop + cursorRow * lineHeight;
        int cursorYBottom = cursorYTop + lineHeight;

        g.drawLine(cursorX, cursorYTop, cursorX, cursorYBottom);
    }
}
