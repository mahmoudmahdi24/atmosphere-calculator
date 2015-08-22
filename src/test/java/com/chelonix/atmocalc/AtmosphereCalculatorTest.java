package com.chelonix.atmocalc;

import static org.assertj.core.api.Assertions.*;

import org.junit.*;

/**
 * Created with IntelliJ IDEA.
 * User: sirot
 * Date: 21/08/15
 * Time: 21:20
 * To change this template use File | Settings | File Templates.
 */
public class AtmosphereCalculatorTest
{
    @Test
    public void should_return_correct_values_at_0m() {
        // Given
        AtmosphereCalculator calc = new AtmosphereCalculator();
        // When
        AtmosphereState value = calc.compute(0);
        // Then
        assertThat(value.getTemperature()).isCloseTo(288.15, within(0.5));
        assertThat(value.getPressure()).isCloseTo(101325, within(1.0));
        assertThat(value.getDensity()).isCloseTo(1.225, within(0.005));
    }

    @Test
    public void should_return_correct_values_at_1000m() {
        // Given
        AtmosphereCalculator calc = new AtmosphereCalculator();
        // When
        AtmosphereState value = calc.compute(1000);
        // Then
        assertThat(value.getTemperature()).isCloseTo(281.65, within(0.5));
        assertThat(value.getPressure()).isCloseTo(89872, within(1.0));
        assertThat(value.getDensity()).isCloseTo(1.111, within(0.005));
    }

    @Test
    public void should_return_correct_values_at_20000m() {
        // Given
        AtmosphereCalculator calc = new AtmosphereCalculator();
        // When
        AtmosphereState value = calc.compute(20000);
        // Then
        assertThat(value.getTemperature()).isCloseTo(216.65, within(0.5));
        assertThat(value.getPressure()).isCloseTo(5471, within(1.0));
        assertThat(value.getDensity()).isCloseTo(0.088, within(0.005));
    }

    @Test
    public void should_fail_on_negative_altitude() {
        // Given
            AtmosphereCalculator calc = new AtmosphereCalculator();
        // When
        try {
            AtmosphereState value = calc.compute(-1);
            fail("IllegalArgumentException expected since altitude is negative");
        } catch (IllegalArgumentException iae) {
            // Then
            assertThat(iae).hasMessage("Altitude must be a positive integer");
        }
    }

    @Test
    public void should_fail_on_altitude_gt_51_Km() {
        // Given
            AtmosphereCalculator calc = new AtmosphereCalculator();
        // When
        try {
            AtmosphereState value = calc.compute(100000);
            fail("IllegalArgumentException expected since altitude is higher than 51 Km");
        } catch (IllegalArgumentException iae) {
            // Then
            assertThat(iae).hasMessage("This model does not work for an altitude above 51 Km");
        }
    }
}
