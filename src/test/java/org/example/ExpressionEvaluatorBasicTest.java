package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ExpressionEvaluatorBasicTest {

    @Test
    public void testExpressionAdd() {
        // Create a mock of the Calculator interface
        CalculatorHelper calculatorHelperMock = mock(CalculatorHelper.class);

        // Set up the behavior of the add method on the mock
        when(calculatorHelperMock.add(2, 3)).thenReturn(5);

        // Create an instance of the class that uses the Calculator
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator(calculatorHelperMock);

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
    }
}