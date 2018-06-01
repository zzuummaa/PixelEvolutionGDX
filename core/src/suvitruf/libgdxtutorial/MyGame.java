package suvitruf.libgdxtutorial;
import suvitruf.libgdxtutorial.screens.*;

import com.badlogic.gdx.Game;
public class MyGame extends Game  {
	//public GameScreen game;
	public GameScreen game;
	public StageScreen stage;

    public MyGame() {
        game = new GameScreen(this);
        stage = new StageScreen(this);
    }

    @Override
	public void create() {
		// TODO Auto-generated method stub
		setScreen(game);
	}
	
	@Override
	public void resize(int width, int height) {
		
	}
/*
	@Override
	public void render() {

	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
	
	}
	*/
	
}
