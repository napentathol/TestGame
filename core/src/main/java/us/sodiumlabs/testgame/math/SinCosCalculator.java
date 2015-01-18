package us.sodiumlabs.testgame.math;

public class SinCosCalculator {
    private static final int CALC_SPECIFICITY = 360;

    private static final float[] sin = new float[CALC_SPECIFICITY];
    private static final float[] cos = new float[CALC_SPECIFICITY];

    static {
        for (int i = 0; i < CALC_SPECIFICITY; i++) {
            sin[i] = (float) Math.sin(Math.toRadians(i));
            cos[i] = (float) Math.cos(Math.toRadians(i));
        }
    }

    public static float cos(final int deg) {
        final int res = deg % CALC_SPECIFICITY;

        // Java does not calculate modulus correctly,
        //  -1 % 360 should be 359, java calculates it
        //  as -1
        return cos[res < 0 ? res + CALC_SPECIFICITY : res];
    }

    public static float sin(final int deg) {
        final int res = deg % CALC_SPECIFICITY;

        return sin[res < 0 ? res + CALC_SPECIFICITY : res];
    }
}
