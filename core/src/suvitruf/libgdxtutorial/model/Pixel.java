package suvitruf.libgdxtutorial.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Pixel implements Collider {
    public enum State {
        NONE, WALKING, DEAD
    }
    public static enum Direction {
        LEFT, RIGHT, UP, DOWN, NONE
    }

    public static final float SPEED = 2f;
    public static final float SIZE = 0.15f;

    private Texture texture;

    Vector2 position = new Vector2();
    Vector2 	velocity = new Vector2();
    Rectangle bounds = new Rectangle();
    Player.State state = Player.State.NONE;
    boolean		facingLeft = true;

    public Pixel(Vector2 position) {
        this(position, null);
    }

    public Pixel(Vector2 position, Texture texture) {
        this.texture = texture;
        this.position = position;
        this.bounds.height = SIZE;
        this.bounds.width = SIZE;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    @Override
    public void onCollision(Collider collision) {
        Rectangle colBound = collision.getBounds();

        if (bounds.width > colBound.width) {
            float newWidth = (float) Math.sqrt(bounds.width*bounds.width + colBound.width*colBound.width);
            bounds.width = newWidth;
            bounds.height = newWidth;
        } else {
            state = State.DEAD;
        }
    }

    @Override
    public boolean isActive() {
        return state != Player.State.DEAD;
    }

    public Vector2 getPosition() {
        return position;
    }
    public Vector2 getVelocity() {
        return velocity;
    }

    public void update(float delta) {
        position.add(velocity.cpy().scl(delta));
    }
}
