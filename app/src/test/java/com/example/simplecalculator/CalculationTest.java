package com.example.simplecalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CalculationTest {
    //---------------------------------------constructor--------------------------------------------
    @Test
    public void testConstructor() {
        Calculation c = new Calculation();

        assertTrue(0 == c.getSize());
        assertTrue(0 == c.getResult());
    }

    //---------------------------------------addOperation-------------------------------------------
    @Test
    public void testAddJustOneOperation() {
        Calculation c1 = new Calculation();

        c1.addNumber("5");
        c1.addOperation("+");

        assertEquals("5+", combineArray(c1));
    }

    @Test
    public void testAddTwoSameOperationsInARow() {
        Calculation c2 = new Calculation();

        c2.addNumber("55");
        c2.addOperation("*");
        c2.addOperation("*");

        assertEquals("55*", combineArray(c2));
    }

    @Test
    public void testAddTwoDifferentOperationsInARow() {
        Calculation c3 = new Calculation();

        c3.addNumber("4");
        c3.addOperation("-");
        c3.addOperation("/");

        assertEquals("4/", combineArray(c3));
    }

    @Test
    public void testAddMultipleDifferentOperationsInARow() {
        Calculation c4 = new Calculation();

        c4.addNumber("9");
        c4.addOperation("*");
        c4.addOperation("/");
        c4.addOperation("-");
        c4.addOperation("+");
        c4.addOperation("+");
        c4.addOperation("-");

        assertEquals("9-", combineArray(c4));
    }

    //----------------------------------------addNumber---------------------------------------------
    @Test
    public void testAddOneNumber() {
        Calculation c1 = new Calculation();

        c1.addNumber("4");

        assertEquals("4", combineArray(c1));
    }

    @Test
    public void testAddMultipleNumber() {
        Calculation c2 = new Calculation();

        c2.addNumber("4");
        c2.addNumber("5");
        c2.addNumber("1");
        c2.addNumber("0");

        assertEquals("4510", combineArray(c2));
    }

    @Test
    public void testAddNumberWithDecimal() {
        Calculation c3 = new Calculation();

        c3.addNumber("5");
        c3.addNumber(".");
        c3.addNumber("6");
        c3.addNumber("9");

        assertEquals("5.69", combineArray(c3));
    }

    //------------------------------------computeCalculation----------------------------------------
    @Test
    public void testComputeCalculationOneOperation() {
        Calculation c1 = new Calculation();

        c1.addNumber("5");
        c1.addOperation("+");
        c1.addNumber("621");

        assertTrue(626 == c1.computeCalculation());
    }

    @Test
    public void testComputeCalculationOneDoubleOperation() {
        Calculation c2 = new Calculation();

        c2.addNumber("5");
        c2.addOperation("+");
        c2.addOperation("-");
        c2.addNumber("621");

        assertTrue(-616 == c2.computeCalculation());
    }

    @Test
    public void testComputeCalculationMultipleOperations() {
        Calculation c3 = new Calculation();

        c3.addNumber("69");
        c3.addOperation("*");
        c3.addNumber("2");
        c3.addOperation("/");
        c3.addNumber("4");
        c3.addOperation("-");
        c3.addNumber("34");

        assertTrue(0.5 == c3.computeCalculation());
    }

    @Test
    public void testComputeCalculationRandom() {
        Calculation c4 = new Calculation();

        c4.addNumber("69");
        c4.addOperation("*");
        c4.addOperation("+");
        c4.addNumber("2");
        c4.addOperation("/");
        c4.addNumber("4");
        c4.addOperation("-");
        c4.addOperation("+");
        c4.addOperation("+");
        c4.addNumber("34");

        assertTrue(51.75 == c4.computeCalculation());
    }



    //---------------------------------------helperFunction-----------------------------------------
    private String combineArray(Calculation c) {
        List<String> array = c.getCalculations();
        String string = "";

        for (int i = 0; i < array.size(); i++) {
            string += array.get(i);
        }

        return string;
    }
}
