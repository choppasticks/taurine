package me.choppa.taurine.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JPanel;
import me.choppa.logging.Logger;
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

        Logger.getInstance().logInfo("not past null");

        BufferHandler buffer = tabHandler.getActiveTab();
        if (buffer == null) {
            return;
        }

        Logger.getInstance().logErr("past null");

        int lineHeight = fontMetrics.getHeight();

        setBackground(backgroundColor);
        setForeground(foregroundColor);

        int distanceFromTop = 20;
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
