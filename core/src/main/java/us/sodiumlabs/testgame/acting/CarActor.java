package us.sodiumlabs.testgame.acting;

import us.sodiumlabs.testgame.input.GameInputProvider;

public class CarActor extends PhysicsActor {

    private GameInputProvider inputProvider;

    private static final float ROT_TORQUE = 0x1p3f;
    private static final float THRUST = 0x1p2f;

    @Override
    public void acceptInputProvider(final GameInputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    @Override
    public void act(final float delta) {
        if(inputProvider.isLeft()) {
            applyTorque(ROT_TORQUE);
        } else if (inputProvider.isRight()) {
            applyTorque(-ROT_TORQUE);
        }

        if(inputProvider.isThrottle()) {
            applyDirectionalForce(THRUST);
        } else if(inputProvider.isBrake()) {
            applyDirectionalForce(-THRUST);
        }

        super.act(delta);
    }
}
