package org.example.gradecalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 요구사항
 * 평균학점 계산 방법 = (학점 수 * 평점)의 합 / 수강 신청한 학점 수
 * 일급 컬렉션 사용
 *     1. 도메인을 구성하는 객체를 먼저 고민
 *     -> 학점 계산기 도메인 : 이수한 과목, 학점 계산기
 *
 *     2. 객체들 간의 관계를 고민
 *     -> 이수한 과목들을 가지고 학점 계산기로 학점을 계
 *
 *     3. 동적인 객체를 정적인 타입으로 추상화하여 도메인 모델링 하기
 *     이수한 과목 : 자료구조, 영어 회화 기초, 자바
 *     -> 위의 3가지 객체를 Course(과목)라는 클래스로 추상화하여 설계
 *
 *     4. 협력 설계
 *     -> 학점계산기에 이수한 과목을 전달하여 평균학점을 계산
 *
 *     5. 객체들을 포괄하는 타입에 적절한 책임 할당
 *     -> 수강 신청한 총 학점의 수를 구하기 : 과목 클래스
 *     -> (학점 수 * 평점)의 합 구하기 : 과목 클래스
 *
 *     6. 구현하기
 */
public class GradeCalculatorTest {

    @Test
    @DisplayName("평균 학점을 계산한다.")
    void calculateGradeTest() {
        List<Course> courses = List.of(new Course("Java", 3, "A+")
                , new Course("Data Structure", 3, "A+")
                , new Course("Basic English Conversation", 3, "A+")
        );

        GradeCalculator gradeCalculator = new GradeCalculator(courses);
        double result = gradeCalculator.calculateGrade();

        assertThat(result).isEqualTo(4.5);
    }
}
