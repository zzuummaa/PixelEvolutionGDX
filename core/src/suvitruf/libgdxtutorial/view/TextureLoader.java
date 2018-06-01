package suvitruf.libgdxtutorial.view;

import com.badlogic.gdx.graphics.Texture;

public class TextureLoader {
    private static TextureLoader instance;

    static {
        instance = new TextureLoader();
    }

    public static TextureLoader instance() {
        return instance;
    }

    private TextureLoader() {
        player = new Texture("Player.bmp");
        smallPixel = new Texture("SmallPixel.bmp");
    }

    private Texture player;
    private Texture smallPixel;

    public Texture getPlayer() {
        return player;
    }

    public Texture getSmallPixel() {
        return smallPixel;
    }
}
