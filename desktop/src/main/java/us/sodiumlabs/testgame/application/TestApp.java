package us.sodiumlabs.testgame.application;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import us.sodiumlabs.testgame.acting.Actor;
import us.sodiumlabs.testgame.acting.CarActor;
import us.sodiumlabs.testgame.input.ClientGameInputProvider;
import us.sodiumlabs.testgame.rendering.GenericActorRenderable;
import us.sodiumlabs.testgame.rendering.GenericSceneRenderer;
import us.sodiumlabs.testgame.rendering.SceneRenderer;

public class TestApp extends ApplicationAdapter {
    SceneRenderer renderer = new GenericSceneRenderer(800, 600);
    Texture img;

    Actor actor;

    @Override
    public void create() {
        actor = new CarActor();

        final ClientGameInputProvider clientProvider = new ClientGameInputProvider();
        Gdx.input.setInputProcessor(clientProvider);
        actor.acceptInputProvider(clientProvider);

        renderer.create();

        final GenericActorRenderable renderable =
                new GenericActorRenderable("DevRaceCar.png");
        renderable.setOffsetRotation(-90);
        renderable.addActor(actor);

        renderer.addRenderable(renderable);
        renderer.follow(actor);
    }

    @Override
    public void render() {
        renderer.render(Gdx.graphics.getDeltaTime());
        actor.act(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void dispose() {
        img.dispose();
        renderer.dispose();
    }
}
