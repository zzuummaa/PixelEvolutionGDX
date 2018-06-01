package suvitruf.libgdxtutorial.model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public interface Collider {
    Vector2 getPosition();

    Rectangle getBounds();

    void onCollision(Collider collision);

    boolean isActive();
}
