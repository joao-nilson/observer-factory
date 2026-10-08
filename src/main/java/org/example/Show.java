package org.example;

import java.util.Observable;

// Observable: the crowd watches it and reacts when it ends
public class Show extends Observable {

    private final String name;

    public Show(String name) {
        this.name = name;
    }

    public void end() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Show{name='" + name + "'}";
    }
}
