package com.uabart.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameRender {

    int x, y;
    int fps;
    private OrthographicCamera cam;
    private GameWorld myWorld;
    private ShapeRenderer shapeRenderer;
    private ShapeRenderer renderRect;
    private SpriteBatch batch;
    private BitmapFont font;
    private Viewport viewport;

    public GameRender(GameWorld world) {
        Gdx.app.log("Render", "started");
        Gdx.graphics.setVSync(true);
        myWorld = world;
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 320, 480);
        viewport = new FitViewport(320, 480, cam);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
        renderRect = new ShapeRenderer();
        renderRect.setProjectionMatrix(cam.combined);
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.DARK_GRAY);
    }

    public void render(float delta) {

        Gdx.gl.glClearColor(1 - fps / 60f, 0 + fps / 60f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        fps = Math.round(1 / delta);
        font.draw(batch, "FPS:" + fps + " FPS:" + Gdx.graphics.getFramesPerSecond(), 0, 15);
        font.draw(batch, "X:" + Gdx.input.getX() + " Y:" + Gdx.input.getY() + "Active:" + Gdx.input.isTouched(), 0, 35);
        batch.end();

    }

    public void resize(int width, int height) {
        viewport.update(width, height);
    }

}
