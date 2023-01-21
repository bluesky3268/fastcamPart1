package org.example.ch3.testcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    @DisplayName("패스워드 초기화")
    void passwordTest() {
        // given
        User user = new User();

        // when
        // as-is
//        user.initPassword(new CorrectFixedPasswordGenerator());

        // to-be : @FunctionalInterface인 경우 굳이 구현체(CorrectFixedPasswordGenerator)를 만들 필요없이 람다를 이용해서 사용할 수 있다.
        user.initPassword(() -> "abcdefgh");


        // then
        assertThat(user.getPassword()).isNotNull();
    }

    @Test
    @DisplayName("패스워드가 요구사항에 부합하지 않아 초기화가 되지 않는다.")
    void passwordTest2() {
        // given
        User user = new User();

        // when
        // as-is
//        user.initPassword(new IncorrectFixedPasswordGenerator());

        // to-be : @FunctionalInterface인 경우 굳이 구현체(IncorrectFixedPasswordGenerator)를 만들 필요없이 람다를 이용해서 사용할 수 있다.
        user.initPassword(() -> "abc");

        // then
        assertThat(user.getPassword()).isNull();
    }
}