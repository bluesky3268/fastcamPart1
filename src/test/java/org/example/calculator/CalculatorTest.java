package org.example.calculator;

import org.assertj.core.util.Streams;
import org.example.calculator.operator.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CalculatorTest {
    /**
     * 요구사항
     * 간단한 사칙연산 동작
     * 양수만 가능
     * 나눗셈에서 0으로 나누는 경우 IllegalArgumentException 발생
     * MVC패턴으로 구현
     */

    @Test
    @DisplayName("덧셈 연산을 수행한다.")
    void additionTest() {
        // given
        int a = 1;
        int b = 2;

        // when
        int result = Calculator.calculate(a, "+", b);

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("뺄셈 연산을 수행한다.")
    void subtractionTest() {
        // given
        int a = 1;
        int b = 2;

        // when
        int result = Calculator.calculate(a, "-", b);

        // then
        assertThat(result).isEqualTo(-1);
    }

    @ParameterizedTest
    @MethodSource("formulaAndResult")
    @DisplayName("연산을 수행한다.")
    void calculateTest(int a, String operator, int b, int result) {
        // given

        // when
        int calcResult = Calculator.calculate(a, operator, b);

        // then
        assertThat(calcResult).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("formulaAndResult")
    @DisplayName("arithmeticCalculate를 통해 연산을 수행한다.")
    void arithmeticCalculateTest(int a, String operator, int b, int result) {
        // given

        // when
        int calcResult = Calculator.arithmeticOperatorCalculate(a, operator, b);

        // then
        assertThat(calcResult).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("formulaAndResult")
    @DisplayName("Calculator2 통해 연산을 수행한다.")
    void calculator2Test(int a, String operator, int b, int result) {
        // given

        // when
        int calcResult = Calculator2.calculate(new PositiveNumber(a), operator, new PositiveNumber(b));

        // then
        assertThat(calcResult).isEqualTo(result);
    }

    @Test
    @DisplayName("Calculator2 0으로 나누면 IllegalArgumentException 발생한다.")
    void dividebyzeroTest() {
        assertThatCode(() -> Calculator2.calculate(new PositiveNumber(5), "/", new PositiveNumber(0)))
                .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("0 또는 음수를 전달할 수 없습니다.");
    }

    private static Stream<Arguments> formulaAndResult() {
        return Stream.of(
                arguments(1, "+", 2, 3)
                , arguments(1, "-", 2, -1)
                , arguments(1, "*", 2, 2)
                , arguments(4, "/", 2, 2)
        );
    }

}
