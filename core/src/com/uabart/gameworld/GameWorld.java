package com.uabart.gameworld;

public class GameWorld {

    private int clock;

    public void update(float delta) {
        clock++;
    }

    public int getClock() {
        return clock;
    }
}
