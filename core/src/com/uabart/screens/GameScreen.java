package com.uabart.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.uabart.helpers.AssetLoader;

public class GameScreen implements Screen {
    public static final int SCREEN_X = 320;
    public static final int SCREEN_Y = 480;
    public static Stage stage;
    public static TextureRegion fullPicture;
    public static int correctX, correctY;
    public static String debug = "";
    public TextureRegion fullPuzzle;
    BitmapFont font;
    private OrthographicCamera cam;
    private Viewport viewport;
    private SpriteBatch batch;


    public GameScreen(String stageName) {
        batch = new SpriteBatch();
        cam = new OrthographicCamera();
        cam.setToOrtho(true, SCREEN_X, SCREEN_Y);
        viewport = new FitViewport(SCREEN_X, SCREEN_Y, cam);
        stage = new Stage(viewport, batch);
        AssetLoader.loadPuzzle(stageName);
        font = new BitmapFont(true);
        font.setColor(1, 1, 1, 1);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.setColor(1, 1, 1, 0.5f);
        batch.draw(fullPicture, correctX, correctY);
        batch.setColor(1, 1, 1, 1);
        font.draw(batch, debug, 30, 30);
        batch.end();
        stage.act(delta);
        stage.draw();
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
