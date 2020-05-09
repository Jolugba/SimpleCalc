package com.tinuade.simplecalc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

/**
 * JUnit4 unit tests for the calculator logic. These are local unit tests; no device needed
 */
@RunWith(JUnit4.class)

public class CalculatorTest {
    private  Calculator calculator;
    /**
     * Set up the environment for testing
     */
    @Before
    public void setUp() {
        calculator = new Calculator();
    }
    /**
     * Test for simple addition
     */
    @Test
    public void addTwoNumbers() {
        double resultAdd = calculator.add(1d, 1d);
        assertThat(resultAdd, is(equalTo(2d)));
    }
    /**
     * Test for simple subtraction
     */
    @Test
    public void addTwoNumbersNegative() {
        double resultAdd = calculator.add(-1d, 2d);
        assertThat(resultAdd, is(equalTo(1d)));
    }
    @Test
    public void addTwoNumbersFloats() {
        double resultAdd = calculator.add(1.111f, 1.111d);
        assertThat(resultAdd, is(closeTo(2.222, 0.01)));
    }
    /**
     * Test for simple subtraction
     */
    @Test
    public void subTwoNumbers(){
        double resultSub=calculator.sub(1d,1d);
        assertThat(resultSub,is(equalTo(0d)));
    }
    @Test
    public void subWorksWithNegativeResult(){
        double resultSub=calculator.sub(1d,17d);
        assertThat(resultSub,is(equalTo(-16d)));
    }
    @Test
    public void mulTwoNumbers(){
        double resultMul=calculator.mul(32d,2d);
        assertThat(resultMul,is(equalTo(64d)));
    }
    @Test
    public void divTwoNumbers(){
        double resultDiv=calculator.div(32d,2d);
        assertThat(resultDiv,is(equalTo(16d)));
    }
    @Test
    public void divTwoNumberZero(){
        double resultDiv=calculator.div(32d,0);
        assertThat(resultDiv,is(equalTo(Double.POSITIVE_INFINITY)));
    }

}