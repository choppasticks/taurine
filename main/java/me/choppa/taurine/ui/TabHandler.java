package me.choppa.taurine.ui;

import java.util.ArrayList;
import java.util.List;
import me.choppa.taurine.editor.BufferHandler;

public class TabHandler {

    private List<BufferHandler> tabs = new ArrayList<>();

    private int selectedTab = 0;

    public TabHandler() {
        tabs.add(new BufferHandler(null));
    }

    public void nextTab() {
        if (!tabs.isEmpty()) {
            selectedTab = (selectedTab + 1) % tabs.size();
        }
    }

    public void previousTab() {
        if (!tabs.isEmpty()) {
            selectedTab = (selectedTab - 1 + tabs.size()) % tabs.size();
        }
    }

    public void closeTab(int tab) {
        if (!tabs.isEmpty()) {
            tabs.remove(tab);
            if (selectedTab >= tabs.size()) {
                selectedTab = Math.max(0, tabs.size() - 1);
            }
        }
    }

    public BufferHandler getActiveTab() {
        return tabs.get(selectedTab);
    }

    public void setSelectedTab(int index) {
        selectedTab = index;
    }
}
