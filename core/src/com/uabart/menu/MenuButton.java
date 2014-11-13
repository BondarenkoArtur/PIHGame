package com.uabart.menu;


public class MenuButton {

    public int screen;
    public int x;
    public int y;
    public int width;
    public int height;
    public String title;
    public int function;

    public MenuButton(int screen, int x, int y, int width, int height, String title, int function) {
        this.screen = screen;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.title = title;
        this.function = function;
    }

}
