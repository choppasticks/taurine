package me.choppa.logging;

import java.util.ArrayList;

public class Logger {

    private static final Logger INSTANCE = new Logger();

    private final ArrayList<String> logs = new ArrayList<>();

    public void log(LogType type, String message) {
        String log = "[" + type.toString() + "]" + message;
        System.out.println(log);
        logs.add(log);
    }

    public void logErr(String message) {
        log(LogType.ERROR, message);
    }

    public void logSevere(String message) {
        log(LogType.SEVERE, message);
    }

    public void logInfo(String message) {
        log(LogType.INFO, message);
    }

    public void logDebug(String message) {
        log(LogType.DEBUG, message);
    }

    public void logWarning(String message) {
        log(LogType.WARNING, message);
    }

    public ArrayList<String> getLogs() {
        return logs;
    }

    public static Logger getInstance() {
        return INSTANCE;
    }
}
