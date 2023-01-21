package org.example.ch3.calculator.operator;

public interface NewArithmeticOperator {
    boolean supports(String operator);

    int calculate(PositiveNumber operand1, PositiveNumber operand2);
}
