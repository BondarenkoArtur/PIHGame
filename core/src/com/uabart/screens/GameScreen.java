package com.uabart.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.uabart.gameworld.GameRender;
import com.uabart.gameworld.GameWorld;
import com.uabart.helpers.InputHandlerGame;

public class GameScreen implements Screen {
    public boolean touched;
    private GameWorld world;
    private GameRender renderer;

    public GameScreen() {
        world = new GameWorld();
        renderer = new GameRender(world);
        Gdx.input.setInputProcessor(new InputHandlerGame());
    }

    @Override
    public void render(float delta) {
        world.update(delta);
        renderer.render(delta);
        touched = Gdx.input.isTouched();
    }

    @Override
    public void resize(int width, int height) {
        renderer.resize(width, height);
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
