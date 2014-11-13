package com.uabart.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;


public class InputHandlerGame implements InputProcessor {

    private int x = 0;

    public InputHandlerGame() {
        Gdx.app.log("Input", "started");
    }

    int getX() {
        return x;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Gdx.app.log("touch", "down");
        x = screenX;
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
