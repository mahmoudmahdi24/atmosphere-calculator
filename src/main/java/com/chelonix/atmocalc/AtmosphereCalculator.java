package com.chelonix.atmocalc;

import static com.chelonix.atmocalc.AtmosphereLayer.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sirot
 * Date: 21/08/15
 * Time: 20:19
 * To change this template use File | Settings | File Templates.
 */
public class AtmosphereCalculator
{
    private static final double G = 9.80665;

    private static final double R = 287.0;

    private static final double T0 = 288.15;

    private static final double P0 = 101325.0;

    private static final double RHO0 = P0 / (R * T0);

    private static final List<AtmosphereLayer> LAYERS = Arrays.asList(
            TROPOSPHERE, STRATOSPHERE_1, STRATOSPHERE_2, STRATOSPHERE_3, MESOSSPHERE_1);

    public AtmosphereState compute(int altitude) {
        if (altitude < 0) {
            throw new IllegalArgumentException("Altitude must be a positive integer");
        }
        if (altitude > 51000) {
            throw new IllegalArgumentException("This model does not work for an altitude above 51 Km");
        }
        return compute(T0, P0, RHO0, LAYERS, altitude);
    }

    private AtmosphereState compute(double t0, double p0, double rho0, List<AtmosphereLayer> layers, int altitude) {
        if (altitude <= 0) {
            return new AtmosphereState(t0, p0, rho0);
        }
        AtmosphereLayer layer = layers.get(0);
        double t1, p1, rho1;
        int h = Math.min(altitude, layer.getHeight());
        double a = layer.getGradient();
        t1 = t0 + layer.getGradient() * h;
        if (a == 0) {
            p1 = p0 * Math.exp(-G * h /(R*t0));
        } else {
            p1 = p0 * Math.pow(t1/t0, -G/(a*R));
        }
        rho1 = p1 / (R * t1);
        return compute(t1, p1, rho1, layers.subList(1, layers.size()), altitude - layer.getHeight());
    }
}
