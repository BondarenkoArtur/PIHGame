package com.uabart.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.uabart.menu.MenuButton;
import com.uabart.screens.MenuScreen;

public class AssetLoader {

    public static Texture button;
    public static int amount;
    private static int counter = 2;
    private static String[] file;


    public static void loadMenu() {
        button = new Texture(Gdx.files.internal("button.png"));
        button.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        file = Gdx.files.internal("buttonlist.txt").readString().split("\\s");
        amount = Integer.parseInt(file[0]);
        for (int i = 0; i < amount; i++) {
            addButton();
        }
    }

    public static void addButton() {
        int screen = Integer.parseInt(file[counter++]);
        int x = Integer.parseInt(file[counter++]);
        int y = Integer.parseInt(file[counter++]);
        int width = Integer.parseInt(file[counter++]);
        int height = Integer.parseInt(file[counter++]);
        String title = file[counter++];
        int function = Integer.parseInt(file[counter++]);
        counter++;
        MenuButton temp = new MenuButton(screen, x, y, width, height, title, function);
        MenuScreen.buttonsList.add(temp);
    }

    public static void disposeMenu() {
        button.dispose();
    }
}
