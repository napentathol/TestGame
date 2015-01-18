package us.sodiumlabs.testgame.math;

public class SinCosCalculator {
    private static final double[] sin = new double[360];
    private static final double[] cos = new double[360];

    static {
        for (int i = 0; i < 360; i++) {
            sin[i] = Math.sin(i);
            cos[i] = Math.cos(i);
        }
    }

    public static double cos(final int deg) {
        return cos[deg % 360];
    }

    public static double sin(final int deg) {
        return sin[deg % 360];
    }
}
