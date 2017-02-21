package com.uabart.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.uabart.menu.MenuButton;
import com.uabart.objects.Piece;
import com.uabart.screens.GameScreen;
import com.uabart.screens.MenuScreen;

public class AssetLoader {

    public static Texture buttonAndOther;
    public static TextureRegion button;
    public static TextureRegion success;
    public static TextureRegion background;
    public static TextureRegion gameBackground;
    public static Texture puzzleTexture;
    public static String[] puzzlePieces;
    public static int piecesAmount;
    public static int buttonsAmount;
    private static int pieceTempCounter;
    private static int pieceRowCounter;
    private static int counter;
    private static String[] file;

    public static void loadMenu() {
        counter = 1;
        buttonAndOther = new Texture(Gdx.files.internal("button.png"));
        buttonAndOther.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        button = new TextureRegion(buttonAndOther, 0, 0, 600, 147);
        background = new TextureRegion(buttonAndOther, 0, 147, 320, 480);
        gameBackground = new TextureRegion(buttonAndOther, 640, 0, 320, 480);
        background.flip(false, true);
        gameBackground.flip(false, true);
        success = new TextureRegion(buttonAndOther, 320, 147, 320, 480);
        success.flip(false, true);
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
        MenuButton temp = new MenuButton(screen, x, y, width, height, title, function);
        MenuScreen.buttonsList.add(temp);
    }

    public static void disposeMenu() {
        buttonAndOther.dispose();
    }

    public static void loadPuzzle(String filename) {
        GameScreen.background = gameBackground;
        pieceTempCounter = 7;
        puzzleTexture = new Texture(Gdx.files.internal(filename + ".png"));
        puzzleTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        puzzlePieces = Gdx.files.internal(filename + ".txt").readString().split("\\s");
        int x = Integer.parseInt(puzzlePieces[0]);
        int y = Integer.parseInt(puzzlePieces[1]);
        int width = Integer.parseInt(puzzlePieces[2]);
        int height = Integer.parseInt(puzzlePieces[3]);
        GameScreen.fullPicture = new TextureRegion(puzzleTexture, x, y, width, height);
        GameScreen.fullPicture.flip(false, true);
        GameScreen.correctX = (GameScreen.SCREEN_X - GameScreen.fullPicture.getRegionWidth()) / 2;
        GameScreen.correctY = (GameScreen.SCREEN_Y - GameScreen.fullPicture.getRegionHeight()) / 2;
        piecesAmount = Integer.parseInt(puzzlePieces[5]);
        for (int i = 0; i < piecesAmount; i++) {
            GameScreen.stage.addActor(addPiece());
        }
    }

    public static void loadAndCutPuzzle(String filename) {
        int widthAmount = 3;
        int heightAmount = 4;
        GameScreen.background = gameBackground;
        pieceTempCounter = 1;
        pieceRowCounter = 1;
        puzzleTexture = new Texture(Gdx.files.internal(filename + ".png"));
        puzzleTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        puzzlePieces = Gdx.files.internal(filename + ".txt").readString().split("\\s");
        int x = Integer.parseInt(puzzlePieces[0]);
        int y = Integer.parseInt(puzzlePieces[1]);
        int width = Integer.parseInt(puzzlePieces[2]);
        int height = Integer.parseInt(puzzlePieces[3]);
        GameScreen.fullPicture = new TextureRegion(puzzleTexture, x, y, width, height);
        GameScreen.fullPicture.flip(false, true);
        GameScreen.correctX = (GameScreen.SCREEN_X - GameScreen.fullPicture.getRegionWidth()) / 2;
        GameScreen.correctY = (GameScreen.SCREEN_Y - GameScreen.fullPicture.getRegionHeight()) / 2;
//        piecesAmount = Integer.parseInt(puzzlePieces[5]);
        int ws = Math.round(width / widthAmount);
        int hs = Math.round(height / heightAmount);
        for (int i = 0; i < widthAmount; i++)
            for (int j = 0; j < heightAmount; j++) {
                GameScreen.stage.addActor(addPiece(i * ws, j * hs, ws, hs ));
            }
    }

    public static Piece addPiece() {
        int x = Integer.parseInt(puzzlePieces[pieceTempCounter++]);
        int y = Integer.parseInt(puzzlePieces[pieceTempCounter++]);
        int width = Integer.parseInt(puzzlePieces[pieceTempCounter++]);
        int height = Integer.parseInt(puzzlePieces[pieceTempCounter++]);
        int correctX = Integer.parseInt(puzzlePieces[pieceTempCounter++]);
        int correctY = Integer.parseInt(puzzlePieces[pieceTempCounter++]);
        TextureRegion textureRegion = new TextureRegion(puzzleTexture, x, y, width, height);
        textureRegion.flip(false, true);
        pieceTempCounter++;
        return new Piece(pieceTempCounter * 7 - (14 * 7), 20, width, height, textureRegion,
                GameScreen.correctX + correctX, GameScreen.correctY + correctY);
    }


    public static Piece addPiece(int x, int y, int width, int height) {
        TextureRegion textureRegion = new TextureRegion(puzzleTexture, x, y, width, height);
        textureRegion.flip(false, true);
        int correctX = x;
        int correctY = y;
        int temp = pieceTempCounter;
        pieceTempCounter += width/2;
        if (pieceTempCounter > GameScreen.SCREEN_X) {
            pieceRowCounter += height/2;
            pieceTempCounter = width/2;
            temp = 1;
        }
        return new Piece(temp, pieceRowCounter , width, height, textureRegion,
                GameScreen.correctX + correctX, GameScreen.correctY + correctY);
    }
}
