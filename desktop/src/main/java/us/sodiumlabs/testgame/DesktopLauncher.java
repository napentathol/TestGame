package us.sodiumlabs.testgame;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import us.sodiumlabs.testgame.application.TestApp;

public class DesktopLauncher {
    public static void main (String[] arg) {
        final LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 800;
        config.height = 600;

        new LwjglApplication(new TestApp(), config);
    }
}