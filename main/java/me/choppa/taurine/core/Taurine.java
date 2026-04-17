package me.choppa.taurine.core;

import me.choppa.taurine.modes.Mode;
import me.choppa.taurine.ui.MainFrame;
import me.choppa.taurine.ui.TabHandler;

public class Taurine {

    private static Taurine instance;
    private MainFrame frame;
    private TabHandler tabHandler;

    public Mode mode = Mode.EDIT;

    public static final String NAME = "Taurine";

    public void init() {
        frame = new MainFrame();
        tabHandler = new TabHandler();
        frame.build();
    }

    public static Taurine getInstance() {
        if (instance == null) {
            instance = new Taurine();
        }
        return instance;
    }

    public MainFrame getFrame() {
        return frame;
    }

    public TabHandler getTabHandler() {
        return tabHandler;
    }
}
