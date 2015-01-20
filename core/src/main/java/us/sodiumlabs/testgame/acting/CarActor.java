package us.sodiumlabs.testgame.acting;

import us.sodiumlabs.testgame.input.GameInputProvider;

public class CarActor extends PhysicsActor {

    private GameInputProvider inputProvider;

    private static final float ROT_TORQUE = 0x1p5f;
    private static final float THRUST = 0x1p6f;

    @Override
    public void acceptInputProvider(final GameInputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    @Override
    public void act(final float delta) {
        if(inputProvider.isBrake()) {
            final float rotVelocityChange = ROT_TORQUE * delta / getMomentInertia();
            final float velChange = THRUST * delta / getMass();

            if(getRotationalVelocity() > rotVelocityChange) {
                applyTorque( 0 - ROT_TORQUE);
            } else if(getRotationalVelocity() < -rotVelocityChange) {
                applyTorque( ROT_TORQUE);
            } else {
                setRotationalVelocity(0);
            }

            if(velChange < getVelocityMagnitude()) {
                applyForces(-THRUST * getVelocityComponentX(), -THRUST * getVelocityComponentY());
            } else {
                setVelocityX(0);
                setVelocityY(0);
            }
        } else if(inputProvider.isThrottle()) {
            applyDirectionalForce(THRUST);
        }

        if (inputProvider.isLeft()) {
            applyTorque(ROT_TORQUE);
        } else if (inputProvider.isRight()) {
            applyTorque(-ROT_TORQUE);
        }

        super.act(delta);
    }

    @Override
    public float getMomentInertia() {
        return getMass();
    }
}
