package com.uabart.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen implements Screen {
    public static Stage stage;
    public boolean touched;
    private OrthographicCamera cam;
    private Viewport viewport;
    private SpriteBatch batch;


    public GameScreen(String stageName) {
        batch = new SpriteBatch();
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 320, 480);
        viewport = new FitViewport(320, 480, cam);
        stage = new Stage(viewport, batch);
//        stage.addActor();
    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
        touched = Gdx.input.isTouched();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
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
        stage.dispose();
    }
}
