package com.uabart.pihgame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.uabart.pihgame.PIHGame;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Put It Here";
        config.width = 320;
        config.height = 480;
        new LwjglApplication(PIHGame.getInstance(), config);
    }
} 