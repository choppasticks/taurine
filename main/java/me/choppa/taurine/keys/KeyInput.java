package me.choppa.taurine.keys;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import me.choppa.taurine.core.Taurine;
import me.choppa.taurine.editor.BufferHandler;

public class KeyInput implements KeyListener {

    private final Taurine taurine = Taurine.getInstance();

    @Override
    public void keyTyped(KeyEvent e) {
        BufferHandler tab = taurine.getTabHandler().getActiveTab();
        char c = e.getKeyChar();
        if (!Character.isISOControl(c)) {
            tab.insert(c);
            taurine.getFrame().getEditorPanel().repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        BufferHandler tab = taurine.getTabHandler().getActiveTab();

        switch (e.getKeyCode()) {
            case KeyEvent.VK_ENTER -> tab.addLine();
            case KeyEvent.VK_BACK_SPACE -> tab.backspace();
            case KeyEvent.VK_UP -> tab.moveUp();
            case KeyEvent.VK_DOWN -> tab.moveDown();
            case KeyEvent.VK_LEFT -> tab.moveLeft();
            case KeyEvent.VK_RIGHT -> tab.moveRight();
        }
        taurine.getFrame().getEditorPanel().repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
