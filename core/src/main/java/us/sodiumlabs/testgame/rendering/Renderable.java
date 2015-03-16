package us.sodiumlabs.testgame.rendering;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import us.sodiumlabs.testgame.utils.Createable;

public interface Renderable extends Createable {
    void render(final float offx, final float offy,
                final float delta, final SpriteBatch batch);
}
