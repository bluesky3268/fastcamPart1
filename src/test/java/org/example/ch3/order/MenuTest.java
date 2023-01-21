package org.example.ch3.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class MenuTest {

    @Test
    @DisplayName("메뉴판에서 메뉴이름에 해당하는 메뉴를 반환한다.")
    void chooseTest() {
        Menu menu = new Menu(List.of(new MenuItem("돈까스", 5000), new MenuItem("라면", 5000)));

        MenuItem menuItem = menu.choose("돈까스");

        assertThat(menuItem).isEqualTo(new MenuItem("돈까스", 5000));
    }

    @Test
    @DisplayName("메뉴판에 없는 메뉴 주문시 예외 반환한다.")
    void chooseTest2() {
        Menu menu = new Menu(List.of(new MenuItem("돈까스", 5000), new MenuItem("라면", 5000)));

        assertThatCode(() -> menu.choose("쫄면"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 메뉴입니다.");
    }
}
