package org.example.testcode;

import org.example.testcode.PasswordValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

/**
 * 요구사항
 * 비밀번호는 8~12자
 * 비밀번호가 8~12자가 아닌 경우 IllegalArgumentException발생
 */
public class PasswordValidatorTest {

    @Test
    @DisplayName("비밀번호가 8자 이상 12자 이하면 예외 발생하지 않음")
    void validatePasswordTest1() {
        assertThatCode(() -> PasswordValidator.validate("hyunbenny123"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("비밀번호가 8자 이상 12자 이하면 IllegalArgumentException이 발생한다.")
    void validatePasswordTest2() {
        assertThatCode(() -> PasswordValidator.validate("hyunbenny123456789"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호 길이는 8~12자입니다.");
    }

    @ParameterizedTest //
    @ValueSource(strings = {"hyunben", "hyunbenny1234"})
    @DisplayName("비밀번호 경계값 테스트")
    void validatePasswordTest3(String password) {
        assertThatCode(() -> PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호 길이는 8~12자입니다.");
    }


}
