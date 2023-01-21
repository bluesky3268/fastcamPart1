package org.example.ch3.gradecalculator;

import java.util.List;

public class GradeCalculator {
    private final Courses courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = new Courses(courses);
    }

    /**
     * 요구사항
     * 평균학점 계산 방법 = (학점 수 * 평점)의 합 / 수강 신청한 학점 수
     * 일급 컬렉션 사용
     */
    public double calculateGrade() {
        //(학점 수 * 평점)의 합
        double totalMultipliedCreditAndCourseGrade = courses.multiplyCreditAndCourseGrade();
        //수강 신청한 학점 수
        int totalCompletedCredit = courses.sumTotalCompletedCourseCredit();
        return totalMultipliedCreditAndCourseGrade / totalCompletedCredit;
    }
}
