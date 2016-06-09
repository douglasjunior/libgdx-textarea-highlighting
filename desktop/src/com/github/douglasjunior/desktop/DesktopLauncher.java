package com.github.douglasjunior.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.github.douglasjunior.SampleGame;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = (int) SampleGame.WIDTH;
        config.height = (int) SampleGame.HEIGHT;
        new LwjglApplication(new SampleGame(), config);
    }
}
