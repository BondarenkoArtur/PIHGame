package com.uabart.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.uabart.menu.MenuButton;
import com.uabart.objects.Piece;
import com.uabart.screens.MenuScreen;

public class AssetLoader {

    public static Texture buttonAndOther;
    public static TextureRegion button;
    public static TextureRegion background;
    public static Texture puzzleTexture;
    public static String[] puzzlePieces;
    public static int piecesAmount;
    public static int buttonsAmount;
    private static int pieceTempCounter = 5;
    private static int counter = 2;
    private static String[] file;

    public static void loadMenu() {
        buttonAndOther = new Texture(Gdx.files.internal("button.png"));
        buttonAndOther.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        button = new TextureRegion(buttonAndOther, 0, 0, 600, 147);
        background = new TextureRegion(buttonAndOther, 0, 147, 320, 480);
        file = Gdx.files.internal("buttonlist.txt").readString().split("\\s");
        buttonsAmount = Integer.parseInt(file[0]);
        for (int i = 0; i < buttonsAmount; i++) {
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
        buttonAndOther.dispose();
    }

    public static void loadPuzzle(String filename) {
        puzzleTexture = new Texture(Gdx.files.internal(filename + ".png"));
        puzzlePieces = Gdx.files.internal(filename + ".txt").readString().split("\\s");
        piecesAmount = Integer.parseInt(puzzlePieces[4]);
        for (int i = 0; i < piecesAmount; i++) {

        }
    }

    public static void addPiece() {
        int x = Integer.parseInt(puzzlePieces[pieceTempCounter++]);
        int y = Integer.parseInt(puzzlePieces[pieceTempCounter++]);
        int width = Integer.parseInt(puzzlePieces[pieceTempCounter++]);
        int height = Integer.parseInt(puzzlePieces[pieceTempCounter++]);
        TextureRegion textureRegion = new TextureRegion(puzzleTexture, x, y, width, height);
        Piece piece = new Piece(x, y, width, height, textureRegion);
    }

}
