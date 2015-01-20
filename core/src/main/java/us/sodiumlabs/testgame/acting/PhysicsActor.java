package us.sodiumlabs.testgame.acting;

import us.sodiumlabs.testgame.math.SinCosCalculator;

public abstract class PhysicsActor implements Actor {
// ------------------------------ FIELDS ------------------------------

    private float x = 0f;
    private float y = 0f;

    public float getRotationalVelocity() {
        return rotationalVelocity;
    }

    public void setRotationalVelocity(float rotationalVelocity) {
        this.rotationalVelocity = rotationalVelocity;
    }

    private float rotationalVelocity = 0f;
    private float velocityX = 0f;
    
    private float velocityY = 0f;

    private float torque = 0f;
    private float forceX = 0f;
    private float forceY = 0f;
    
    private float rotation = 0f;
    private float mass = 1f;

// --------------------- GETTER / SETTER METHODS ---------------------

    public float getMass() {
        return mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public float getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(float velocityX) {
        this.velocityX = velocityX;
    }

    public float getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(float velocityY) {
        this.velocityY = velocityY;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

// ------------------------ INTERFACE METHODS ------------------------


// --------------------- Interface Actor ---------------------

    @Override
    public void act(final float delta) {
        updatePosition(delta);
        updateAngle(delta);
        zeroForces();
    }

// -------------------------- OTHER METHODS --------------------------

    public void applyDirectionalForce(final float force) {
        applyForces(SinCosCalculator.cos((int)rotation) * force, SinCosCalculator.sin((int)rotation) * force);
    }

    public void applyForces(final float x, final float y) {
        forceX += x;
        forceY += y;
    }

    public void applyTorque(final float torque) {
        this.torque += torque;
    }
    
    public float getVelocityComponentX() { 
        return getVelocityMagnitude() == 0 ? 0 : getVelocityX() / getVelocityMagnitude();
    }

    public float getVelocityMagnitude() {
        return (float) Math.sqrt( getVelocityX() * getVelocityX() + getVelocityY() * getVelocityY() );
    }

    public float getVelocityComponentY() {
        return getVelocityMagnitude() == 0 ? 0 : getVelocityY() / getVelocityMagnitude();
    }

    protected void updateAngle(final float delta) {
        rotationalVelocity += torque * delta / getMomentInertia();

        rotation += rotationalVelocity * delta;
    }
    
    public abstract float getMomentInertia();

    private void updatePosition(final float delta) {
        velocityX += forceX * delta / mass;
        velocityY += forceY * delta / mass;

        x += velocityX * delta;
        y += velocityY * delta;
    }

    public void zeroForces() {
        forceX = 0f;
        forceY = 0f;
        torque = 0f;
    }
}
