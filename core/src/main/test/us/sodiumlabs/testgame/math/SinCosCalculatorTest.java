package us.sodiumlabs.testgame.math;

import org.junit.Assert;
import org.junit.Test;

public class SinCosCalculatorTest {
    @Test
    public void testCosSpeed() {
        final long calculatorTestStart = System.currentTimeMillis();

        for(int i = 0; i < 360 * 10000; i++) {
            SinCosCalculator.cos(i);
        }

        final long calculatorTestTime = System.currentTimeMillis() - calculatorTestStart;

        final long mathTestStart = System.currentTimeMillis();

        for(int i = 0; i < 360 * 10000; i++) {
            Math.cos(i);
        }

        final long mathTestTime = System.currentTimeMillis() - mathTestStart;

        Assert.assertTrue("Calculator test time took longer than Math test time:\n" +
                        "\tMath time: " + mathTestTime +
                        ", Calculator time: " + calculatorTestTime,
                mathTestTime > calculatorTestTime);
    }

    @Test
    public void testSinSpeed() {
        final long calculatorTestStart = System.currentTimeMillis();

        for(int i = 0; i < 360 * 10000; i++) {
            SinCosCalculator.sin(i);
        }

        final long calculatorTestTime = System.currentTimeMillis() - calculatorTestStart;

        final long mathTestStart = System.currentTimeMillis();

        for(int i = 0; i < 360 * 10000; i++) {
            Math.sin(i);
        }

        final long mathTestTime = System.currentTimeMillis() - mathTestStart;

        Assert.assertTrue("Calculator test time took longer than Math test time:\n" +
                        "\tMath time: " + mathTestTime +
                        ", Calculator time: " + calculatorTestTime,
                mathTestTime > calculatorTestTime);
    }
}