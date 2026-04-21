package me.choppa.taurine.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JPanel;
import me.choppa.taurine.core.Taurine;
import me.choppa.taurine.editor.BufferHandler;

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

        TabHandler tabHandler = taurine.getTabHandler();

        BufferHandler buffer = tabHandler.getActiveTab();

        /*
         * int tabGap = 0;
         * for (BufferHandler bufferHandler : tabHandler.getTabs()) {
         *
         * int x = tabGap += 30;
         * int y = 2;
         * int width = 30;v
         * int height = 20;
         * if (bufferHandler == buffer) {
         * g.setColor(Color.GREEN);
         * } else {
         * g.setColor(Color.WHITE);
         * }
         * g.fillRect(x, y, width, height);
         * g.setColor(Color.BLACK);
         * g.drawString(bufferHandler.getName(), x + 5, y + 15);
         *
         * }
         */

        int lineHeight = fontMetrics.getHeight();

        setBackground(backgroundColor);
        setForeground(foregroundColor);

        int distanceFromTop = 40;
        int textY = distanceFromTop;

        int lineCount = 1;

        int gutterWidth = 30;
        for (StringBuilder stringBuilder : buffer.getLines()) {
            g.drawString(stringBuilder.toString(), gutterWidth, textY);
            String lineNumb = String.format("%2d", lineCount);
            g.drawString(lineNumb, 2, textY);
            lineCount++;
            textY += lineHeight;
        }

        int cursorRow = buffer.getCursorRow();
        int cursorColumn = buffer.getCursorColumn();

        String currentLine = buffer.getLines().get(cursorRow).toString();
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
