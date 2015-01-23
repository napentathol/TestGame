package us.sodiumlabs.testgame.rendering;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Renderable {
// -------------------------- OTHER METHODS --------------------------

    void create();
    void dispose();
    void render(final float offx, final float offy,
                final float delta, final SpriteBatch batch);
}
