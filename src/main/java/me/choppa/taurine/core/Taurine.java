package me.choppa.taurine.core;

import me.choppa.logging.Logger;
import me.choppa.taurine.files.FileHandler;
import me.choppa.taurine.modes.Mode;
import me.choppa.taurine.ui.MainFrame;
import me.choppa.taurine.ui.TabHandler;

public class Taurine {

    private static Taurine instance;
    private MainFrame frame;
    private TabHandler tabHandler;
    private FileHandler fileHandler;

    public Mode mode = Mode.EDIT;

    public static final String NAME = "Taurine";
    public static final double VERSION = 0.0;

    public void init() {
        frame = new MainFrame();
        tabHandler = new TabHandler();
        fileHandler = new FileHandler();
        frame.build();
        Logger.getInstance().logInfo("Taurine initialized");
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

    public FileHandler getFileHandler() {
        return fileHandler;
    }
}
