package org.example.gradecalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class CourseTest {

    @Test
    @DisplayName("과목을 생성한다.")
    void createTest() {
        assertThatCode(() -> new Course("Java", 3, "A"))
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("학점 정보를 가져온다.")
    void getCredit() {
        Course java = new Course("Java", 3, "A");
        assertThat(java.getCredit()).isEqualTo(3);
    }

    @Test
    @DisplayName("성적 정보를 숫자로 가져온다.")
    void getGradeToNumber() {
        Course java = new Course("Java", 3, "A");
        assertThat(java.getGradeToNumber()).isEqualTo(4.0);
    }
}
