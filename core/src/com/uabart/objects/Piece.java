package com.uabart.objects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Piece extends Actor {

    public TextureRegion texture;
    public boolean correctPlace;

    public Piece(int x, int y, int width, int height, TextureRegion texture) {
        this.setX(x);
        this.setY(y);
        this.setWidth(width);
        this.setHeight(height);
        this.texture = texture;
        correctPlace = false;
    }

    public boolean isCorrectPlace() {
        return correctPlace;
    }




}
