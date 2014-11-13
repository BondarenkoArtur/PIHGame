package com.uabart.helpers;

import com.badlogic.gdx.InputProcessor;

public class InputHandlerMenu implements InputProcessor {

    private Controller myController;

    public InputHandlerMenu(Controller controller) {
        myController = controller;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        myController.onClick(screenX, screenY);
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        myController.onDrag(screenX, screenY);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
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
    public boolean scrolled(int amount) {
        return false;
    }
}
