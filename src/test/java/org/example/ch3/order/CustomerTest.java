package org.example.ch3.order;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

/**
 * 음식점 주문 과정 구현
 * 1. 요구사항
 *   - 손님, 메뉴판, 메뉴(MenuItem), 요리사(Chef), 요리된 요리 객체(Cook)
 * 2. 객체 간 관계
 *   - 손님 - 메뉴판
 *   - 손님 - 요리사
 *   - 요리사 - 요리
 *
 * 3. 동적인 객체를 정적인 객체로 추상화하여 모델링하기
 *     - 손님 - 손님 타입
 *     - 돈까스, 라면, 김밥 등 - 요리 타입
 *     - 메뉴판 - 메뉴판 타입
 *     - 메뉴 - 메뉴 타입
 */
public class CustomerTest {

    @Test
    @DisplayName("메뉴를 주문한다.")
    void orderTest() {

        Customer customer = new Customer();
        Menu menu = new Menu(List.of(new MenuItem("돈까스", 5000), new MenuItem("라면", 5000)));
        Chef chef = new Chef();

        assertThatCode(() -> customer.order("돈까스", menu, chef))
            .doesNotThrowAnyException();
    }
}
