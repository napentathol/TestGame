package us.sodiumlabs.testgame.acting;

public interface Actor {
    public void act(final float delta);
    public void setX(final float x);
    public void setY(final float y);

    public float getX();
    public float getY();
}
