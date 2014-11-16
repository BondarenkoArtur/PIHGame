package com.uabart.objects;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.uabart.screens.GameScreen;

public class Piece extends Actor {

    public int correctX;
    public int correctY;
    public TextureRegion texture;
    public boolean fullSize = false;
    private float movX, movY;

    public Piece(int x, int y, final int width, final int height, TextureRegion texture, final int correctX, final int correctY) {
        this.setX(correctX);
        this.setY(correctY);
        this.setWidth(width * 0.5f);
        this.setHeight(height * 0.5f);
        this.correctX = correctX;
        this.correctY = correctY;
        this.texture = texture;
        addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Piece.this.setWidth(width);
                Piece.this.setHeight(height);
                movX = x;
                movY = y;
                return true;

            }

            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                Piece.this.setX(getX() + x - movX);
                Piece.this.setY(getY() + y - movY);
                movX = x;
                movY = y;
                GameScreen.debug = "" + movX + ":" + movY;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                boolean correct = false;
                if (Piece.this.getX() < Piece.this.correctX + 10 && Piece.this.getX() > Piece.this.correctX - 10) {
                    if (Piece.this.getY() < Piece.this.correctY + 10 && Piece.this.getY() > Piece.this.correctY - 10) {
                        Piece.this.setTouchable(Touchable.disabled);
                        Piece.this.setX(correctX);
                        Piece.this.setY(correctY);
                        correct = true;
                    }
                }
                if (!correct) {
                    Piece.this.setWidth(width * 0.5f);
                    Piece.this.setHeight(height * 0.5f);
                }
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, this.getX(), this.getY(), getWidth(), getHeight());
    }
}
