package com.uabart.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.uabart.screens.GameScreen;

public class Piece extends Actor {

    public int correctX;
    public int correctY;
    public TextureRegion texture;
    private float movX, movY;

    public Piece(int x, int y, final int width, final int height, final TextureRegion texture, final int correctX, final int correctY) {
        this.setX(x);
        this.setY(y);
        this.setWidth(width * 0.5f);
        this.setHeight(height * 0.5f);
        this.correctX = correctX;
        this.correctY = correctY;
        this.texture = texture;
        addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Piece.this.setWidth(width);
                Piece.this.setHeight(height);
                return true;

            }

            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                Piece.this.setX(getX() + Gdx.input.getDeltaX(pointer));
                Piece.this.setY(getY() + Gdx.input.getDeltaY(pointer));
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if (Piece.this.getX() < Piece.this.correctX + 10 && Piece.this.getX() > Piece.this.correctX - 10) {
                    if (Piece.this.getY() < Piece.this.correctY + 10 && Piece.this.getY() > Piece.this.correctY - 10) {
                        GameScreen.finished.addActor(new Piece(correctX, correctY, width * 2, height * 2, texture, correctX, correctY));
                        Piece.this.remove();
                    }
                }
                    Piece.this.setWidth(width * 0.5f);
                    Piece.this.setHeight(height * 0.5f);
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, this.getX(), this.getY(), getWidth(), getHeight());
    }
}
