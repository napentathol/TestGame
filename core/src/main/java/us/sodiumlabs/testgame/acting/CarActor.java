package us.sodiumlabs.testgame.acting;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import us.sodiumlabs.testgame.input.GameInputProvider;

public class CarActor extends PhysicsActor {

    private static final BodyDef CAR_DEF = new BodyDef();

    private static final float ROT_TORQUE = 0x5Ap10f;
    private static final float THRUST = 0x1p8f;

    static {
        CAR_DEF.position.set(10,10);
        CAR_DEF.type = BodyDef.BodyType.DynamicBody;
    }

    private GameInputProvider inputProvider;

    private static Body createCarBody(final World world) {
        final CircleShape circleShape = new CircleShape();
        circleShape.setRadius(6f);

        final FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circleShape;
        fixtureDef.density = 0.5f;
        fixtureDef.friction = 0.4f;
        fixtureDef.restitution = 0.6f;

        final Body body = world.createBody(CAR_DEF);
        body.createFixture(fixtureDef);

        circleShape.dispose();

        return body;
    }

    public CarActor(final World world) {
        super(createCarBody(world));
    }

    @Override
    public void act(final float delta) {
        if(inputProvider.isBrake()) {
            final float rotVelocityChange = ROT_TORQUE * delta / getBody().getInertia();
            final float velChange = THRUST * delta / getBody().getMass();

            final Vector2 unit = getBody().getLinearVelocity().cpy().nor();

            if(getBody().getAngularVelocity() > rotVelocityChange) {
                getBody().applyTorque(-ROT_TORQUE, true);
            } else if(getBody().getAngularVelocity() < -rotVelocityChange) {
                getBody().applyTorque(ROT_TORQUE, true);
            } else {
                getBody().setAngularVelocity(0);
            }

            if(velChange < getBody().getLinearVelocity().len()) {
                getBody().applyForceToCenter(
                        -THRUST * unit.x,
                        -THRUST * unit.y,
                        true);
            } else {
                getBody().setLinearVelocity(0, 0);
            }
        } else if(inputProvider.isThrottle()) {
            applyDirectionalForce(THRUST);
        }

        if (inputProvider.isLeft()) {
            getBody().applyTorque(ROT_TORQUE, true);
        } else if (inputProvider.isRight()) {
            getBody().applyTorque(-ROT_TORQUE, true);
        }
    }

    @Override
    public void acceptInputProvider(final GameInputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }
}
