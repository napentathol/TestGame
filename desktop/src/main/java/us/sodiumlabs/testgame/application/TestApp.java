package us.sodiumlabs.testgame.application;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import us.sodiumlabs.testgame.acting.Actor;
import us.sodiumlabs.testgame.acting.CarActor;
import us.sodiumlabs.testgame.input.ClientGameInputProvider;
import us.sodiumlabs.testgame.rendering.*;

public class TestApp extends ApplicationAdapter {
    private SceneRenderer renderer = new GenericSceneRenderer(800, 600);

    private Actor actor;

    private World world;

    @Override
    public void create() {
        world = new World(new Vector2(0, 0), true);
        actor = new CarActor(world);

        final ClientGameInputProvider clientProvider = new ClientGameInputProvider();
        Gdx.input.setInputProcessor(clientProvider);
        actor.acceptInputProvider(clientProvider);

        renderer.create();

        final Renderable bg = new Background("test_background.png");
        renderer.addRenderable(bg);

        final GenericActorRenderable renderable =
                new GenericActorRenderable("DevRaceCar.png");
        renderable.setOffsetRotation(-90);
        renderable.addActor(actor);

        renderer.addRenderable(renderable);
        renderer.follow(actor);
    }

    @Override
    public void render() {
        final float delta = Gdx.graphics.getDeltaTime();

        renderer.render(delta);
        actor.act(delta);
        if(!world.isLocked()) {
            world.step(delta, 1, 1);
        }
    }

    @Override
    public void dispose() {
        renderer.dispose();
        world.dispose();
    }
}
