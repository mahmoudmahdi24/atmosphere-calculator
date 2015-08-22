package com.chelonix.atmocalc.server;

import com.chelonix.atmocalc.AtmosphereCalculator;
import com.chelonix.atmocalc.AtmosphereState;
import net.codestory.http.Query;
import net.codestory.http.annotations.Get;

/**
 * Created with IntelliJ IDEA.
 * User: sirot
 * Date: 22/08/15
 * Time: 08:38
 * To change this template use File | Settings | File Templates.
 */
public class AtmosphereCalculatorResource
{
    private final AtmosphereCalculator calculator;

    public AtmosphereCalculatorResource(AtmosphereCalculator calculator) {
        this.calculator = calculator;
    }

    @Get("/")
    public AtmosphereState compute(Query query) {
        int altitude = query.getInteger("altitude");
        return calculator.compute(altitude);
    }
}
