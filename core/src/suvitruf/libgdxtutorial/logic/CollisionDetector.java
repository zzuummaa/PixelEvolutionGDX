package suvitruf.libgdxtutorial.logic;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import suvitruf.libgdxtutorial.model.Collider;

public class CollisionDetector<T extends Collider> {
    private static CollisionDetector ourInstance = new CollisionDetector();

    public static CollisionDetector getInstance() {
        return ourInstance;
    }

    private CollisionDetector() {
    }

    public synchronized void detectCollisions(Array<T> colliders) {

        for (int i = 0; i < colliders.size; i++) {
            Collider col1 = colliders.get(i);

            if (!col1.isActive()) continue;

            for (int j = i+1; j < colliders.size; j++) {
                Collider col2 = colliders.get(j);

                if (!col2.isActive()) continue;

                if ( isCollision(col1, col2) ) {
                    col1.onCollision(col2);
                    col2.onCollision(col1);
                }
            }
        }
    }

    public boolean isCollision(Collider col1, Collider col2) {
        Rectangle b1 = new Rectangle(col1.getBounds());
        b1.x += col1.getPosition().x;
        b1.y += col1.getPosition().y;

        Rectangle b2 = new Rectangle(col2.getBounds());
        b2.x += col2.getPosition().x;
        b2.y += col2.getPosition().y;

        return b1.overlaps(b2);

        /*if (b1.x > b2.x && b1.x < b2.x + b2.width
        &&  b1.y > b2.y && b1.y < b2.y + b2.height) {
            return true;
        }

        if (b1.x + b1.width > b2.x && b1.x + b1.width < b2.x + b2.width
        &&  b1.y > b2.y && b1.y < b2.y + b2.height) {
            return true;
        }

        if (b1.x > b2.x && b1.x < b2.x + b2.width
        &&  b1.y + b1.height > b2.y && b1.y + b1.height < b2.y + b2.height) {
            return true;
        }

        if (b1.x + b1.width > b2.x && b1.x + b1.width < b2.x + b2.width
        &&  b1.y + b1.height > b2.y && b1.y + b1.height < b2.y + b2.height) {
            return true;
        }

        return false;*/
    }
}
