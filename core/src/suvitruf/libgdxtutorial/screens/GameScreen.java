package suvitruf.libgdxtutorial.screens;

import suvitruf.libgdxtutorial.MyGame;
import suvitruf.libgdxtutorial.logic.CollisionDetector;
import suvitruf.libgdxtutorial.model.*;
import suvitruf.libgdxtutorial.controller.*;
import suvitruf.libgdxtutorial.view.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Application.ApplicationType;

import com.badlogic.gdx.graphics.GL20;

import static com.badlogic.gdx.Input.*;

public class GameScreen implements Screen, InputProcessor {
	private MyGame game;

	private World 			world;
	private WorldRenderer 	renderer;
	private WorldController	controller;

	private int width, height;

    public GameScreen(MyGame game) {
        this.game = game;
    }

    @Override
	public void show() {

		world = new World();
		renderer = new WorldRenderer(world);
		controller = new WorldController(world);
		Gdx.input.setInputProcessor(this);

	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) {
		changeNavigation(x,y);
		return false;
	}

	
	public boolean touchMoved(int x, int y) {
		return false;
	}

	@Override
	public boolean mouseMoved(int x, int y) {
		return false;
	}
	
	@Override
	public boolean keyTyped(char character) {
		return false;
	}
	
	@Override
	public void resize(int width, int height) {
		renderer.setSize(width, height);
		this.width = width;
		this.height = height;
	}

	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {		
		Gdx.input.setInputProcessor(null);
	}


	@Override
	public boolean keyDown(int keycode) {
        if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
            Gdx.app.exit();
        }

		switch (keycode) {
            case Keys.W: controller.upPressed(); break;
            case Keys.S: controller.downPressed(); break;
            case Keys.A: controller.leftPressed(); break;
            case Keys.D: controller.rightPressed(); break;
        }

		return true;
	}

	@Override
	public void render(float delta) {

		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		controller.update(delta);
		CollisionDetector.getInstance().detectCollisions(world.getPixels());
		renderer.render();
	}
	@Override
	public boolean keyUp(int keycode) {
        switch (keycode) {
            case Keys.W: controller.upReleased(); break;
            case Keys.S: controller.downReleased(); break;
            case Keys.A: controller.leftReleased(); break;
            case Keys.D: controller.rightReleased(); break;
        }

		return true;
	}
	
	private void changeNavigation(int x, int y){
		controller.resetWay();
		if(height-y >  controller.player.getPosition().y * renderer.ppuY)
			controller.upPressed();
		
		if(height-y <  controller.player.getPosition().y * renderer.ppuY)
			controller.downPressed();
		
		if ( x< controller.player.getPosition().x * renderer.ppuX) 
			controller.leftPressed();
			
		if (x> (controller.player.getPosition().x +Player.SIZE)* renderer.ppuX)
			controller.rightPressed();
			
	}
	
	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {

		//if (!Gdx.app.getType().equals(ApplicationType.Android))
		//	return false;
		//changeNavigation(x,y);
        game.setScreen(game.stage);
		return true;
	} 
	
	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		if (!Gdx.app.getType().equals(ApplicationType.Android))
			return false;
		controller.resetWay();
		
		return true;
	}
	
	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
