package us.sodiumlabs.testgame.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class ClientGameInputProvider extends InputAdapter implements GameInputProvider {

    private boolean left, right, throttle, brake;

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.W : throttle = false;   break;
            case Input.Keys.A : left = false;       break;
            case Input.Keys.S : brake = false;      break;
            case Input.Keys.D : right = false;      break;
        }

        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.W : throttle = true;    break;
            case Input.Keys.A : left = true;        break;
            case Input.Keys.S : brake = true;       break;
            case Input.Keys.D : right = true;       break;
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
