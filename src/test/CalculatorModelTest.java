package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class CalculatorModelTest {
	
	//All Junit Model Tests

    private CalculatorModel model;

    @Before
    public void setUp() {
        model = new CalculatorModel();
    }

    @Test
    public void testAddition() {
        double result = model.add(5, 3);
        assertEquals(8.0, result, 0.0001);
    }

    @Test
    public void testSubtraction() {
        double result = model.subtract(10, 4);
        assertEquals(6.0, result, 0.0001);
    }

    @Test
    public void testMultiplication() {
        double result = model.multiply(7, 6);
        assertEquals(42.0, result, 0.0001);
    }

    @Test
    public void testDivision() {
        double result = model.divide(20, 5);
        assertEquals(4.0, result, 0.0001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        model.divide(5, 0);
    }

    @Test
    public void testSquare() {
        double result = model.square(5);
        assertEquals(25.0, result, 0.0001);
    }

    @Test
    public void testSquareRoot() {
        double result = model.sqrt(16);
        assertEquals(4.0, result, 0.0001);
    }

    @Test(expected = ArithmeticException.class)
    public void testSquareRootNegative() {
        model.sqrt(-9);
    }

    @Test
    public void testMemoryAdd() {
        model.addMemory(10);
        model.addMemory(5);
        assertEquals(15.0, model.recallMemory(), 0.0001);
    }

    @Test
    public void testMemorySubtract() {
        model.addMemory(20);
        model.subtractMemory(5);
        assertEquals(15.0, model.recallMemory(), 0.0001);
    }

    @Test
    public void testMemoryRecall() {
        model.addMemory(7);
        double memory = model.recallMemory();
        assertEquals(7.0, memory, 0.0001);
    }

    @Test
    public void testMemoryClear() {
        model.addMemory(50);
        model.clearMemory();
        assertEquals(0.0, model.recallMemory(), 0.0001);
    }
}
