package suvitruf.libgdxtutorial.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import suvitruf.libgdxtutorial.model.*;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class WorldRenderer {
	public static float CAMERA_WIDTH = 8f;
	public static  float CAMERA_HEIGHT = 5f;
	
	private World world;
	public OrthographicCamera cam;
	ShapeRenderer renderer = new ShapeRenderer();
    SpriteBatch spriteBatch = new SpriteBatch();


    public int width;
	public int height;
	public float ppuX;	// пикселей на точку мира по X 
	public float ppuY;	// пикселей на точку мира по Y 
	
	public void setSize (int w, int h) {
		this.width = w;
		this.height = h;  
		ppuX = (float)width / CAMERA_WIDTH;
		ppuY = (float)height / CAMERA_HEIGHT;
	}
	
	public void SetCamera(float x, float y){
		this.cam.position.set(x, y,0);	
		this.cam.update();
	}
	
	public WorldRenderer(World world) {
		
		this.world = world;
		this.cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
		SetCamera(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f);

	}

	public void render() {
	    drawPixels();
	}

	private void drawPixels() {
		spriteBatch.setProjectionMatrix(cam.combined);
		spriteBatch.begin();

		Array<Pixel> pixels = world.getPixels();
		for (int i = 0; i < pixels.size; i++) {
			Pixel pixel = pixels.get(i);

			if (!pixel.isActive()) continue;

			Rectangle rect = pixel.getBounds();
			float x1 = pixel.getPosition().x + rect.x;
			float y1 = pixel.getPosition().y + rect.y;
			spriteBatch.draw(pixel.getTexture(), x1, y1, rect.width, rect.height);
		}

		spriteBatch.end();
	}
	
}
