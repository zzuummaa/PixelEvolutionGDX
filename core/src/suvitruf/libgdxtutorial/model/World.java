package suvitruf.libgdxtutorial.model;


import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import suvitruf.libgdxtutorial.view.TextureLoader;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.abs;

public class World {
	Array<Pixel> pixels = new Array<Pixel>();
	public Player player;
	
	public int width;
	public int height;

	public Player getPlayer() {
		return player;
	}
	
	public World() {
		
		width = 8;
		height = 5;

		createWorld(15);
		
	}

    public Array<Pixel> getPixels() {
        return pixels;
    }

    public void createWorld(int pixelCount) {
		player = new Player(new Vector2(6,2));
		player.setTexture(TextureLoader.instance().getPlayer());
		pixels.add(player);

		Random random = new Random(12);
        for (int i = 0; i < pixelCount; i++) {
            float x = abs(random.nextInt() % 48) / 8f;
            float y = abs(random.nextInt() % 32) / 8f;
            pixels.add(new Pixel(new Vector2(x, y), TextureLoader.instance().getSmallPixel()));
        }
	}
}
