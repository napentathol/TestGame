package us.sodiumlabs.testgame.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class ClientGameInputProvider extends InputAdapter implements GameInputProvider {

    private boolean left, right, throttle, brake;

    private int leftIn = Input.Keys.A,
            rightIn = Input.Keys.D,
            throttleIn = Input.Keys.W,
            brakeIn = Input.Keys.S;

    @Override
    public boolean keyUp(int keycode) {
        if(throttleIn == keycode) {
            throttle = false;
        }
        if(brakeIn == keycode) {
            brake = false;
        }
        if(leftIn == keycode) {
            left = false;
        }
        if(rightIn == keycode) {
            right = false;
        }

        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        if(throttleIn == keycode) {
            throttle = true;
        }
        if(brakeIn == keycode) {
            brake = true;
        }
        if(leftIn == keycode) {
            left = true;
        }
        if(rightIn == keycode) {
            right = true;
        }

        return false;
    }

    @Override
    public boolean isLeft() {
        return left && !right;
    }

    @Override
    public boolean isRight() {
        return right && !left;
    }

    @Override
    public boolean isThrottle() {
        return throttle && !brake;
    }

    @Override
    public boolean isBrake() {
        return brake && !throttle;
    }
}
