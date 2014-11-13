package com.uabart.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;
import com.uabart.menu.MenuButton;
import com.uabart.screens.MenuScreen;

/**
 * Created by Arthur on 11/13/2014.
 */
public class Controller {

    int x;
    int y;

    public Controller() {

    }

    public void onClick(int screenX, int screenY) {
        Vector3 pos = new Vector3(screenX, screenY, 0);
        MenuScreen.camera.unproject(pos);
        Gdx.app.log("X:" + pos.x, "Y:" + pos.y);
        for (MenuButton button : MenuScreen.buttonsList) {
            if (pos.x >= x && pos.x <= button.width + x) {
                if (pos.y >= y && pos.y <= button.height + y) {
                    doFunc(button);
                }
            }
        }
    }

    public void doFunc(MenuButton button) {
        switch (button.function) {
            case 1:
                Gdx.app.log("1", "clicked");
            case 2:
                Gdx.app.log("2", "clicked");
            default:
        }
    }


    public void onDrag(int screenX, int screenY) {

    }
}
