package us.sodiumlabs.testgame.rendering;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface SceneRenderer extends Renderable {
    void render(final float delta);

    void render(final float delta, final SpriteBatch batch);

    void create();

    void dispose();

    void addRenderable(final Renderable renderable);

    void removeRenderable(final Renderable renderable);
}