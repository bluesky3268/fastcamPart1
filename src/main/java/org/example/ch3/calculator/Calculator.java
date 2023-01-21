package org.example.ch3.calculator;

public class Calculator {

    public static int calculate(int operand1, String operator, int operand2) {
        if (operand2 == 0) {
            throw new IllegalArgumentException("나누는 수는 0이 될 수 없습니다.");
        }

        switch (operator) {
            case "+" :
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*" :
                return operand1 * operand2;
            case "/" :
                return operand1 / operand2;
        }

        return 0;
    }

    public static int arithmeticOperatorCalculate(int operand1, String operator, int operand2) {
        return ArithmeticOperator.calculate(operand1, operator, operand2);
    }
}
