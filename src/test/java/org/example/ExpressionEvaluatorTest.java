package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ExpressionEvaluatorTest {
    //comment

    private CalculatorHelper calculatorHelperMock;
    private ExpressionEvaluator expressionEvaluator;
    @Before
    public void setup() {
        // Create a mock of the Calculator interface
        calculatorHelperMock= mock(CalculatorHelper.class);

        // Create an instance of the class that uses the Calculator
        expressionEvaluator = new ExpressionEvaluator(calculatorHelperMock);
    }

    @Test
    public void testExpressionAdd() {

        // Set up the behavior of the add method on the mock
        when(calculatorHelperMock.add(2, 3)).thenReturn(5);

        // Perform the test using the mock
        int result = 0;
        try {
            result = expressionEvaluator.evaluate("2+3");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Verify that the add method was called with the expected arguments
        verify(calculatorHelperMock).add(2, 3);

        // Verify that the result is as expected
        assertEquals(5, result);



        // was the method called twice?
        when(calculatorHelperMock.add(5, 10)).thenReturn(15);
        when(calculatorHelperMock.add(5, 10)).thenReturn(15);

        try {
            result = expressionEvaluator.evaluate("5+10");
            result = expressionEvaluator.evaluate("5+10");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        verify(calculatorHelperMock, times(2)).add(5, 10);
    }

    @Test
    public void testExpressionSubtract() {
        // TODO with atLeast
    }

    @Test
    public void testExpressionMultiply() {
        // TODO with atMost
    }

    @Test
    public void testExpressionDivide() {
        // TODO
    }
}