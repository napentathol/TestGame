package us.sodiumlabs.testgame.acting;

import com.badlogic.gdx.physics.box2d.Body;
import us.sodiumlabs.testgame.math.SinCosCalculator;

public abstract class PhysicsActor implements Actor {
    private final Body body;

    public PhysicsActor(final Body body) {
        this.body = body;
    }

    @Override
    public float getX() {
        return body.getPosition().x;
    }

    @Override
    public float getY() {
        return body.getPosition().y;
    }

    @Override
    public float getRotation() {
        return body.getAngle();
    }

    public Body getBody() {
        return body;
    }

    public void applyDirectionalForce(final float force) {
        body.applyForceToCenter(
                SinCosCalculator.cos((int) getRotation()) * force,
                SinCosCalculator.sin((int) getRotation()) * force,
                true);
    }
}
