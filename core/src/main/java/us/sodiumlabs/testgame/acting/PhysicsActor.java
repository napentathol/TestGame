package us.sodiumlabs.testgame.acting;

public abstract class PhysicsActor implements Actor {
// ------------------------------ FIELDS ------------------------------

    private float x;
    private float y;

    private float velocityX;
    private float velocityY;
    
    private float rotation;
    private float mass;

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
    public void act(float delta) {
        
    }
}
