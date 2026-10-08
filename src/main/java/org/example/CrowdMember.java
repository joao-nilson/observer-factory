package org.example;

import java.util.Observable;
import java.util.Observer;

// Observer: reacts to the show ending by clapping
public abstract class CrowdMember implements Observer {

    private final String name;
    private String lastClap;

    protected CrowdMember(String name) {
        this.name = name;
    }

    public String getLastClap() {
        return this.lastClap;
    }

    public void watch(Show show) {
        show.addObserver(this);
    }

    // each type of crowd member claps in its own way
    public abstract String clap();

    @Override
    public void update(Observable show, Object arg) {
        this.lastClap = this.name + ": " + clap();
        // System.out.println(this.lastClap);
    }
}
