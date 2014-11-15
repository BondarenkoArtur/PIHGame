package com.uabart.pihgame;

import com.badlogic.gdx.Game;
import com.uabart.screens.GameScreen;
import com.uabart.screens.MenuScreen;

public class PIHGame extends Game {

    public static PIHGame instance = new PIHGame();
    private MenuScreen mainMenuScreen;
    private GameScreen gameScreen;

    private PIHGame() {
    }

    public static PIHGame getInstance() {
        return instance;
    }

    @Override
    public void create() {
        mainMenuScreen = new MenuScreen(1);
        gameScreen = new GameScreen("pinguin");
        setScreen(mainMenuScreen);
    }

    public void showGame() {
        setScreen(gameScreen);
    }

    public void showMainMenu() {
        setScreen(mainMenuScreen);
    }

} 