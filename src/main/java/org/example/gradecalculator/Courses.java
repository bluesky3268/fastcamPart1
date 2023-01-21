package org.example.gradecalculator;

import java.util.List;

public class Courses {
    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    //(학점 수 * 평점)의 합
    public double multiplyCreditAndCourseGrade() {
//        double multipliedCreditAndCourseGrade = 0;
//        for (Course course : courses) {
//            multipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
//        }
//        return multipliedCreditAndCourseGrade;

        return courses.stream()
                .mapToDouble(course -> course.multiplyCreditAndCourseGrade())
                .sum();
    }

    //수강 신청한 학점 수
    public int sumTotalCompletedCourseCredit() {
        return courses.stream()
                .mapToInt(course -> course.getCredit()).sum();
    }
}
