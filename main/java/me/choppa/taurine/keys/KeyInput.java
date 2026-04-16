package me.choppa.taurine.keys;

import me.choppa.taurine.core.Taurine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {
    private final Taurine taurine = Taurine.getInstance();


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ENTER -> taurine.getBufferHandler().addLine();
            case KeyEvent.VK_BACK_SPACE -> taurine.getBufferHandler().backspace();
            case KeyEvent.VK_UP -> taurine.getBufferHandler().moveUp();
            case KeyEvent.VK_DOWN -> taurine.getBufferHandler().moveDown();
            case KeyEvent.VK_LEFT -> taurine.getBufferHandler().moveLeft();
            case KeyEvent.VK_RIGHT -> taurine.getBufferHandler().moveRight();
            default -> taurine.getBufferHandler().insert((char) e.getKeyCode());
        }
        taurine.getFrame().getEditorPanel().repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
