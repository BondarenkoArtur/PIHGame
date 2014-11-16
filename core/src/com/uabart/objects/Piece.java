package com.uabart.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.uabart.screens.GameScreen;

public class Piece extends Actor {

    public int correctX;
    public int correctY;
    public TextureRegion texture;

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
                Piece.this.setX(getX() - width / 4.0f);
                Piece.this.setY(getY() - height / 4.0f);
                Piece.this.setWidth(width);
                Piece.this.setHeight(height);
                return true;

            }

            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                Vector3 pos = new Vector3(Gdx.input.getDeltaX(pointer), Gdx.input.getDeltaY(pointer), 0);
                GameScreen.cam.unproject(pos);
                Piece.this.setX(getX() + pos.x);
                Piece.this.setY(getY() + pos.y);
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if (Piece.this.getX() < Piece.this.correctX + 20 && Piece.this.getX() > Piece.this.correctX - 20) {
                    if (Piece.this.getY() < Piece.this.correctY + 20 && Piece.this.getY() > Piece.this.correctY - 20) {
                        GameScreen.finished.addActor(new Piece(correctX, correctY, width * 2, height * 2, texture, correctX, correctY));
                        Piece.this.remove();
                    }
                }
                Piece.this.setX(getX() + width / 4.0f);
                Piece.this.setY(getY() + height / 4.0f);
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
