package us.sodiumlabs.testgame.application;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import us.sodiumlabs.testgame.acting.Actor;
import us.sodiumlabs.testgame.acting.CarActor;
import us.sodiumlabs.testgame.input.ClientGameInputProvider;
import us.sodiumlabs.testgame.input.DelegatingInputAdapter;
import us.sodiumlabs.testgame.rendering.*;

public class TestApp extends ApplicationAdapter {
    private SceneRenderer renderer = new GenericSceneRenderer(800, 600);

    private CarActor wasdActor;
    private CarActor arrowActor;

    private World world;

    @Override
    public void create() {
        world = new World(new Vector2(0, 0), true);
        wasdActor = new CarActor(world);
        arrowActor = new CarActor(world);

        final DelegatingInputAdapter delegatingInputAdapter = new DelegatingInputAdapter();

        final ClientGameInputProvider wasdClientProvider = new ClientGameInputProvider();
        delegatingInputAdapter.addInputAdapter(wasdClientProvider);
        wasdActor.acceptInputProvider(wasdClientProvider);

        final ClientGameInputProvider arrowClientProvider = new ClientGameInputProvider();
        arrowClientProvider.setBrakeIn(Input.Keys.DOWN);
        arrowClientProvider.setThrottleIn(Input.Keys.UP);
        arrowClientProvider.setLeftIn(Input.Keys.LEFT);
        arrowClientProvider.setRightIn(Input.Keys.RIGHT);

        delegatingInputAdapter.addInputAdapter(arrowClientProvider);
        arrowActor.acceptInputProvider(arrowClientProvider);

        Gdx.input.setInputProcessor(delegatingInputAdapter);
        arrowActor.getBody().setTransform(50, 50, 90);

        renderer.create();

        final Renderable bg = new Background("test_background.png");
        renderer.addRenderable(bg);

        final GenericActorRenderable renderable =
                new GenericActorRenderable("DevRaceCar.png");
        renderable.setOffsetRotation(-90);
        renderable.addActor(wasdActor);
        renderable.addActor(arrowActor);

        renderer.addRenderable(renderable);
        renderer.follow(wasdActor);
    }

    @Override
    public void render() {
        final float delta = Gdx.graphics.getDeltaTime();

        renderer.render(delta);
        wasdActor.act(delta);
        arrowActor.act(delta);
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
