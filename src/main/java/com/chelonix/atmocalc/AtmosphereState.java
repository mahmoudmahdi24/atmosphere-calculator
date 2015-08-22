package com.chelonix.atmocalc;

/**
 * Created with IntelliJ IDEA.
 * User: sirot
 * Date: 21/08/15
 * Time: 20:34
 * To change this template use File | Settings | File Templates.
 */
public class AtmosphereState
{
    private double temperature;
    private double pressure;
    private double density;

    public AtmosphereState(double temperature, double pressure, double density)
    {
        this.temperature = temperature;
        this.pressure = pressure;
        this.density = density;
    }

    public double getTemperature()
    {
        return temperature;
    }

    public double getPressure()
    {
        return pressure;
    }

    public double getDensity()
    {
        return density;
    }
}
