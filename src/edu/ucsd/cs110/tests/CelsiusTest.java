package edu.ucsd.cs110.tests;

import static org.junit.Assert.*;
import edu.ucsd.cs110.temperature.Celsius;
import edu.ucsd.cs110.temperature.Temperature;
import junit.framework.TestCase;

// "TestCase" is used to specify a test fixture which holds actual tests
public class CelsiusTest extends TestCase{
    private float delta = 0.001f;

    // "testXXXX" - Prefixing a method with test indicates to the test fixture that
    // the method should be considered a test case.
    public void testCelsius(){
        float value = 12.34f;
        Celsius temp = new Celsius(value);

        // Each test case has one or more assertions
        assertEquals(value, temp.getValue(), delta);
    }

    public void testCelsiusToString(){
        float value = 12.34f;

        Celsius temp = new Celsius(value);
        String string = temp.toString();

        String beginning = "" + value;
        String ending = " C";

        // Verify the suffix of the formatted string
        assertTrue(string.startsWith(beginning));

        // Verify the prefix of the formatted string
        assertTrue(string.endsWith(ending));

        // Verify the middle of the formatted string
        int endIndex = string.indexOf(ending);

        // (Hint: what is the length of the middle of the string?)
        assertTrue(string.substring(0, endIndex).equals(beginning));

        // wrong ver.
        // assertTrue(string.substring(1, endIndex).equals(beginning));
    }

    public void testCelsiusToCelsius()
    {
        Celsius temp = new Celsius(0);
        Temperature convert = temp.toCelsius();
        assertEquals(0, convert.getValue(), delta);
    }

    public void testCelsiusToFahrenheit(){
        Celsius temp = new Celsius(0);

        Temperature convert = temp.toFahrenheit();

        // Because precise equality between floating point numbers is not guaranteed,
        // this form of assertEquals relaxes the definition of “equality” by allowing
        // the two values being compared to differ by a small amount.
        assertEquals(32, convert.getValue(), delta);

        temp = new Celsius(100);
        convert = temp.toFahrenheit();

        assertEquals(212, convert.getValue(), delta);
    }
}