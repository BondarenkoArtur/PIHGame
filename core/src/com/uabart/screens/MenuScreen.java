package com.uabart.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.uabart.helpers.AssetLoader;
import com.uabart.helpers.Controller;
import com.uabart.helpers.InputHandlerMenu;
import com.uabart.menu.MenuButton;

import java.util.ArrayList;
import java.util.List;

public class MenuScreen implements Screen {
    public static final int SCREEN_X = 320;
    public static final int SCREEN_Y = 480;
    public static List<MenuButton> buttonsList = new ArrayList<MenuButton>();
    public static OrthographicCamera camera;
    public static int currentScreen;
    public Controller controller = new Controller();
    private BitmapFont font;
    private SpriteBatch batch;

    public MenuScreen(int screen) {
        AssetLoader.loadMenu();
        currentScreen = screen;
        camera = new OrthographicCamera();
        camera.setToOrtho(true, SCREEN_X, SCREEN_Y);
        batch = new SpriteBatch();
        batch.setProjectionMatrix(camera.combined);
        font = new BitmapFont(true);
        font.setColor(Color.DARK_GRAY);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.setColor(1, 1, 1, 1);
        batch.draw(AssetLoader.background, 0, 0);
        for (MenuButton button : buttonsList) {
            if (button.screen == currentScreen) {
                batch.draw(AssetLoader.button, button.x, button.y, button.width, button.height);
                float fontX = button.x + button.width / 2 - font.getBounds(button.title).width / 2;
                float fontY = button.y + button.height / 2 - font.getBounds(button.title).height / 2;
                font.draw(batch, button.title, fontX, fontY);
            }
        }
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputHandlerMenu(controller));
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
        AssetLoader.disposeMenu();
    }
}
