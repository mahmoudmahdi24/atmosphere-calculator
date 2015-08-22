package com.chelonix.atmocalc;

/**
 * Created with IntelliJ IDEA.
 * User: sirot
 * Date: 21/08/15
 * Time: 20:19
 * To change this template use File | Settings | File Templates.
 */
public enum AtmosphereLayer
{
    TROPOSPHERE(-0.0065, 11000),
    STRATOSPHERE_1(0.0, 9000),
    STRATOSPHERE_2(0.001, 12000),
    STRATOSPHERE_3(0.0028, 15000),
    MESOSSPHERE_1(0, 4000);

    private final double gradient;
    private final int height;

    AtmosphereLayer(double gradient, int height) {
        this.gradient = gradient;
        this.height = height;
    }

    public double getGradient()
    {
        return gradient;
    }

    public int getHeight()
    {
        return height;
    }
}
