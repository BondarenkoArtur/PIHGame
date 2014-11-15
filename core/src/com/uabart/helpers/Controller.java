package com.uabart.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;
import com.uabart.menu.MenuButton;
import com.uabart.pihgame.PIHGame;
import com.uabart.screens.MenuScreen;

public class Controller {

    public Controller() {

    }

    public void onClick(int screenX, int screenY) {
        Vector3 pos = new Vector3(screenX, screenY, 0);
        MenuScreen.camera.unproject(pos);
        Gdx.app.log("X:" + pos.x, "Y:" + pos.y);
        for (MenuButton button : MenuScreen.buttonsList) {
            if (button.screen == MenuScreen.currentScreen) {
                if (pos.x >= button.x && pos.x <= button.width + button.x) {
                    if (pos.y >= button.y && pos.y <= button.height + button.y) {
                        doFunc(button);
                    }
                }
            }
        }
    }

    public void doFunc(MenuButton button) {
        switch (button.function) {
            case 1:
                Gdx.app.log("1", "clicked");
                PIHGame.getInstance().showGame();
                break;
            case 2:
                Gdx.app.log("2", "clicked");
                break;
            default:
        }
    }

    public void onDrag(int screenX, int screenY) {

    }
}
