package me.choppa.taurine.ui.components;

import java.awt.Graphics;

public class ButtonComponent extends Component {

    // private Color buttonColor = new Color(160, 95, 78);

    public ButtonComponent(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void paint(Graphics g) {
        //g.setColor(buttonColor);
        //g.fillRect(x, y, width, height);
    }
}
