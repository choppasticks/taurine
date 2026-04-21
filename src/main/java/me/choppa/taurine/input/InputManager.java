package me.choppa.taurine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import me.choppa.taurine.input.keyboard.PanelInput;

public class InputManager implements KeyListener {

    private final PanelInput panelInput = new PanelInput();

    @Override
    public void keyTyped(KeyEvent e) {
        panelInput.onKeyTyped(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        panelInput.onKeyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
