package com.uabart.pihgame;

import com.badlogic.gdx.Game;
import com.uabart.screens.GameScreen;
import com.uabart.screens.MenuScreen;

public class PIHGame extends Game {

    public static PIHGame instance = new PIHGame();

    private PIHGame() {
    }

    public static PIHGame getInstance() {
        return instance;
    }

    @Override
    public void create() {
        showMainMenu();
    }

    public void showGame(String string) {
        setScreen(new GameScreen(string));
    }

    public void showMainMenu() {
        showMenu(1);
    }

    public void showMenu(int number) {
        setScreen(new MenuScreen(number));
    }

} 