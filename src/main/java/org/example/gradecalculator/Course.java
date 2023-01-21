package org.example.gradecalculator;

public class Course {

    private String subject; // 과목
    private int credit; // 학점
    private String grade; // 성적

    public Course(String subject, int credit, String grade) {
        this.subject = subject;
        this.credit = credit;
        this.grade = grade;
    }

    public int getCredit() {
        return this.credit;
    }

    /**
     * 문자열로 받은 성적(A+, A, B+ ...)을 숫자로 변환(4.5, 4.0, 3.5 ...)
     */
    public double getGradeToNumber() {
        double grade = 0;
        switch (this.grade) {
            case "A+":
                grade = 4.5;
                break;
            case "A":
                grade = 4.0;
                break;
            case "B+":
                grade = 3.5;
                break;
            case "B":
                grade = 3.0;
                break;
            case "C+":
                grade = 2.5;
                break;
            case "C":
                grade = 2.0;
                break;
        }
        return grade;
    }

    public double multiplyCreditAndCourseGrade() {
        return this.credit * getGradeToNumber();
    }
}
