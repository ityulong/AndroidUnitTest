package testing.example.com;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import testing.example.com.java_test.Calculator;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private Calculator mCalculator;

    @Before
    public void setUp() throws Exception {
        mCalculator = new Calculator();
    }

    @After
    public void tearDown() throws Exception {
        mCalculator = null;
    }

    @Test
    public void sum() {
        assertEquals(6, mCalculator.sum(1, 5), 0);
    }

    @Test
    @Ignore(" not implement ")
    public void substract() {
        assertEquals("test",-4, mCalculator.substract(1, 5), 0);

    }

    @Test(expected = IllegalArgumentException.class)
    public void divide() {
//        assertEquals(2, mCalculator.divide(4, 2), 0);
        mCalculator.divide(1, 0);

    }

    @Test
    public void multiply() {
        assertEquals(8, mCalculator.multiply(4, 2), 0);

    }
}