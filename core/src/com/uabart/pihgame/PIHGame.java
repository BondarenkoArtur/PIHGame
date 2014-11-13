package com.uabart.pihgame;

import com.badlogic.gdx.Game;
import com.uabart.screens.MenuScreen;

public class PIHGame extends Game {

    @Override
    public void create() {
//        setScreen(new GameScreen());
        setScreen(new MenuScreen(1));
    }

} 