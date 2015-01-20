package us.sodiumlabs.testgame.rendering;

import us.sodiumlabs.testgame.acting.Actor;

public interface ActorRenderable extends Renderable {
    void addActor(final Actor actor);

    void removeActor(final Actor actor);
}
