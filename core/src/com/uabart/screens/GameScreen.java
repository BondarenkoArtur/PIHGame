package com.uabart.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.uabart.helpers.AssetLoader;
import com.uabart.pihgame.PIHGame;

public class GameScreen implements Screen {
    public static final int SCREEN_X = 320;
    public static final int SCREEN_Y = 480;
    public static Stage stage;
    public static TextureRegion fullPicture;
    public static int correctX, correctY;
    public static String debug = "";
    public static Group finished;
    public static TextureRegion background;
    public static OrthographicCamera cam;
    private BitmapFont font;
    private Viewport viewport;
    private SpriteBatch batch;
    private boolean run;

    public GameScreen(String stageName) {
        batch = new SpriteBatch();
        cam = new OrthographicCamera();
        cam.setToOrtho(true, SCREEN_X, SCREEN_Y);
        viewport = new FitViewport(SCREEN_X, SCREEN_Y, cam);
        stage = new Stage(viewport, batch);
        finished = new Group();
        stage.addActor(finished);
        finished.setTouchable(Touchable.disabled);
        AssetLoader.loadAndCutPuzzle(stageName);
        font = new BitmapFont(true);
        font.setColor(1, 1, 1, 1);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(background, 0, 0);
        batch.setColor(1, 1, 1, 0.3f);
        batch.draw(fullPicture, correctX, correctY);
        batch.setColor(1, 1, 1, 1);
        font.draw(batch, debug, 30, 30);
        batch.end();
        stage.act(delta);
        stage.draw();
        int countTouchables = 0;
        for (Actor actor : stage.getActors()) {
            if (actor.isTouchable()) break;
            countTouchables++;
        }
        if (countTouchables == stage.getActors().size)
            PIHGame.getInstance().showMenu(2);
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
