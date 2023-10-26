package org.example;

import static java.lang.Integer.parseInt;

/*
Evaluates a simple expression with two operands and one operator (+,-,*,/)
 */
public class ExpressionEvaluator {
    private final CalculatorHelper calculatorHelper;

    public ExpressionEvaluator(CalculatorHelper calculator) {
        this.calculatorHelper = calculator;
    }

    public int evaluate(String str) throws Exception {

        // split non-alphanumeric character
        String[] operands = str.split("[^\\w]+");

        int firstOperand = parseInt(operands[0]);
        int secondOperand = parseInt(operands[1]);

        if (str.contains("+") ){
            return calculatorHelper.add(firstOperand,secondOperand);
        } else if (str.contains("-")) {
           return calculatorHelper.subtract(firstOperand, secondOperand);
        } else if (str.contains("*")) {
            return calculatorHelper.multiply(firstOperand, secondOperand);
        } else if (str.contains("-")){
            return calculatorHelper.divide(firstOperand, secondOperand);
        }

        throw new Exception("Incorrect input string");
    }
}
