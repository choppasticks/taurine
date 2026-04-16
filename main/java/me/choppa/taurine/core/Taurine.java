package me.choppa.taurine.core;

import me.choppa.taurine.buffer.BufferHandler;
import me.choppa.taurine.ui.MainFrame;

public class Taurine {
    private static Taurine instance;
    private BufferHandler bufferHandler;
    private MainFrame frame;

    public static final String NAME = "Taurine";

    public void init() {
        bufferHandler = new BufferHandler();
        frame = new MainFrame();

        bufferHandler.getLines().add(new StringBuilder());

        frame.build();
    }

    public static Taurine getInstance() {
        if (instance == null) {
            instance = new Taurine();
        }
        return instance;
    }

    public BufferHandler getBufferHandler() {
        return bufferHandler;
    }

    public MainFrame getFrame() {
        return frame;
    }
}
