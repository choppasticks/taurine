package me.choppa.taurine.editor;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BufferHandler {

    private final List<StringBuilder> lines = new ArrayList<>();

    private Path filePath;
    private String name;

    private int cursorRow = 0;
    private int cursorColumn = 0;

    public BufferHandler(Path filePath) {
        this(filePath, "unsaved");
    }

    public BufferHandler(Path filePath, String name) {
        this.filePath = filePath;
        this.name = name;
        lines.add(new StringBuilder("Hello, World!"));
    }

    public void moveUp() {
        if (cursorRow > 0) {
            cursorRow--;
            cursorColumn = lines.get(cursorRow).length();
        }
    }

    public void moveDown() {
        if (cursorRow < lines.size() - 1) {
            cursorRow++;
            cursorColumn = 0;
        }
    }

    public void moveLeft() {
        if (cursorColumn > 0) {
            cursorColumn--;
        }
    }

    public void moveRight() {
        if (cursorColumn < lines.get(cursorRow).length()) {
            cursorColumn++;
        }
    }

    public void addLine() {
        StringBuilder currentLine = new StringBuilder();
        lines.add(cursorRow + 1, currentLine);
        cursorRow++;
        cursorColumn = 0;
    }

    public void backspace() {
        if (cursorColumn > 0) {
            lines.get(cursorRow).deleteCharAt(cursorColumn - 1);
            cursorColumn--;
        } else {
            if (cursorRow > 0) {
                lines.get(cursorRow - 1).append(lines.get(cursorRow));
                lines.remove(cursorRow);
                cursorRow--;
                cursorColumn = lines.get(cursorRow).length();
            }
        }
    }

    public void insert(char c) {
        lines.get(cursorRow).insert(cursorColumn, c);
        cursorColumn++;
    }

    public List<StringBuilder> getLines() {
        return lines;
    }

    public int getCursorRow() {
        return cursorRow;
    }

    public int getCursorColumn() {
        return cursorColumn;
    }

    public String getName() {
        return name;
    }

    public Path getFilePath() {
        return filePath;
    }
}
