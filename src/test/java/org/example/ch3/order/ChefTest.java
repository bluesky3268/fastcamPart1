package org.example.ch3.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ChefTest {

    @Test
    @DisplayName("메뉴에 해당하는 음식을 만든다.")
    void cookTest() {
        Chef chef = new Chef();
        MenuItem menuItem = new MenuItem("라면", 5000);

        Cook cook = chef.cook(menuItem);

        assertThat(cook).isEqualTo(new Cook("라면", 5000));
    }
}
