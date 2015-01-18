package us.sodiumlabs.testgame.application;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import us.sodiumlabs.testgame.acting.Actor;
import us.sodiumlabs.testgame.rendering.GenericSceneRenderer;
import us.sodiumlabs.testgame.rendering.Renderable;
import us.sodiumlabs.testgame.rendering.SceneRenderer;

public class TestApp extends ApplicationAdapter {
    SceneRenderer renderer = new GenericSceneRenderer();
    SpriteBatch batch;
    Texture img;

    Actor actor;
    InputAdapter inputAdapter;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("DevRaceCar.png");

        inputAdapter = new InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {
                return super.keyDown(keycode);
            }

            @Override
            public boolean keyUp(int keycode) {
                return super.keyUp(keycode);
            }
        };

        actor = new Actor() {
            float x = 100f;
            float y = 100f;

            @Override
            public void act(float delta) {

                System.out.println(System.currentTimeMillis());
            }

            @Override public void setX(float x) { this.x = x; }

            @Override public void setY(float y) { this.y = y; }

            @Override public float getX() { return x; }

            @Override public float getY() { return y; }
        };

        renderer.create();

        renderer.addRenderable(new Renderable() {
            @Override
            public void create() { }

            @Override
            public void dispose() { }

            @Override
            public void render(float delta, SpriteBatch batch) {
                render(0, 0, delta, batch);
            }

            @Override
            public void render(float offx, float offy, float delta, SpriteBatch batch) {
                batch.draw(img, actor.getX() + offx, actor.getY() + offy, 0, 0, 18, 22);
            }
        });
    }

    @Override
    public void render() {
        renderer.render(Gdx.graphics.getDeltaTime());
        actor.act(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        renderer.dispose();
    }
}
