package com.mygdx.game.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;
import suvitruf.libgdxtutorial.MyGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.width = 1000;
		cfg.height = 650;
		new LwjglApplication(new MyGame(), cfg);

        // set resolution to HD ready (1280 x 720) and set full-screen to true
        //Gdx.graphics.setDisplayMode(1100, 650, true);

        // set resolution to default and set full-screen to true
        /*Gdx.graphics.setDisplayMode(
                Gdx.graphics.getDesktopDisplayMode().width,
                Gdx.graphics.getDesktopDisplayMode().height,
                false
        );*/
	}
}
