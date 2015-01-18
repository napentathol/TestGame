package us.sodiumlabs.testgame.input;

public interface GameInputProvider {
    public boolean isLeft();
    public boolean isRight();
    public boolean isThrottle();
    public boolean isBrake();
}
