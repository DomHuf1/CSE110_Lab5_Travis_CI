package edu.ucsd.cs110.temperature;
public class Celsius extends Temperature
{
    public Celsius(float t)
    {
        super(t);
    }

    @Override
    public Temperature toCelsius() {
        return this;
    }

    @Override
    public Temperature toFahrenheit() {
        Temperature tempF = new Fahrenheit(this.getValue() * 9 / 5 + 32);
        return tempF;
    }

    public String toString()
    {
        return "" + this.getValue() + " C";
    }
}