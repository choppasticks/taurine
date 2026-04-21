package me.choppa.taurine.input.mouse;

import java.awt.event.MouseEvent;
import me.choppa.taurine.core.Taurine;

public abstract class MouseInput {

    protected Taurine taurine = Taurine.getInstance();

    public abstract void onMouseClicked(MouseEvent e);

    public abstract void onMousePressed(MouseEvent e);

    public abstract void onMouseReleased(MouseEvent e);

    public abstract void onMouseMoved(MouseEvent e);

    public abstract void onMouseDragged(MouseEvent e);
}
