package us.sodiumlabs.testgame.rendering;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import us.sodiumlabs.testgame.acting.Actor;

import java.util.LinkedList;
import java.util.List;

public class GenericActorRenderable implements ActorRenderable {
// ------------------------------ FIELDS ------------------------------

    final Texture image;
    
    final float width, height, halfWidth, halfHeight;

    float offsetRotation;

    final List<Actor> actorsToRender = new LinkedList<>();

// --------------------------- CONSTRUCTORS ---------------------------

    public GenericActorRenderable(final String imageName) {
        image = new Texture(imageName);

        width = image.getWidth();
        height = image.getHeight();
        halfWidth = width / 2f;
        halfHeight = height / 2f;
    }

// --------------------- GETTER / SETTER METHODS ---------------------

    public float getOffsetRotation() {
        return offsetRotation;
    }

    public void setOffsetRotation(float offsetRotation) {
        this.offsetRotation = offsetRotation;
    }

// ------------------------ INTERFACE METHODS ------------------------


// --------------------- Interface ActorRenderable ---------------------

    @Override
    public void addActor(final Actor actor) {
        actorsToRender.add(actor);
    }

    @Override
    public void removeActor(final Actor actor) {
        actorsToRender.remove(actor);
    }

// --------------------- Interface Renderable ---------------------


    @Override
    public void create() { }

    @Override
    public void dispose() { }

    @Override
    public void render(final float offx, final float offy, final float rotation, final float delta, final SpriteBatch batch) {
        actorsToRender.stream().forEach(
                a -> batch.draw(image,
                        a.getX() + offx - halfWidth,
                        a.getY() + offy - halfHeight,
                        halfWidth,
                        halfHeight,
                        width,
                        height,
                        1,
                        1,
                        a.getRotation() + rotation + getOffsetRotation(),
                        0, 0,
                        image.getWidth(), image.getHeight(),
                        false, false
                    )
        );
    }
}
