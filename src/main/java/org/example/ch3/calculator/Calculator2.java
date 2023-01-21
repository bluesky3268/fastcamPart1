package org.example.ch3.calculator;

import org.example.ch3.calculator.operator.*;

import java.util.List;

public class Calculator2 {
    private static final List<NewArithmeticOperator> operatorList = List.of(new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator());

    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
        return operatorList.stream().filter(arithmeticOperator -> arithmeticOperator.supports(operator))
                .map(arithmeticOperator -> arithmeticOperator.calculate(operand1, operand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙 연산이 아닙니다."));
    }
}
