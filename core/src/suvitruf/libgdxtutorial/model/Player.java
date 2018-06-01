package suvitruf.libgdxtutorial.model;

import com.badlogic.gdx.math.Vector2;

public class Player extends Pixel implements Collider {

	public Player(Vector2 position) {
		super(position);
		bounds.width = 0.3f;
		bounds.height = 0.3f;
	}

	@Override
	public void onCollision(Collider collision) {
		super.onCollision(collision);
		System.out.println("player collision");
	}

	@Override
	public void update(float delta) {
		position.add(velocity.cpy().scl(delta));

//		if (velocity.x != 0 || velocity.y != 0) {
//			System.out.println("Player new pos: x=" + position.x + ", y=" + position.y);
//		}
	}
}