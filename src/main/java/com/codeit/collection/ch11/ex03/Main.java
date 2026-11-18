// 파일 이름: Main.java
package com.codeit.collection.ch11.ex03;

import java.util.List;

// 수강 내역 한 건: 어떤 학생이 어떤 강의를 어느 학기에 듣고 몇 점을 받았는지.
// Student나 Course 객체 대신 학번(studentId)과 강의 코드(courseCode)만 가집니다.
// 성적표를 만들 때는 서비스에서 이 두 값으로 학생과 강의를 다시 찾아 연결합니다.
class Enrollment {
    private final long studentId;
    private final String courseCode;
    private final String semester;
    private final int score;

    Enrollment(long studentId, String courseCode, String semester, int score) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.semester = semester;
        this.score = score;
    }

    // getter: 학기별 인원(groupingBy(Enrollment::getSemester)), 강의별 평균(averagingInt(Enrollment::getScore))에 씁니다.
    long getStudentId() { return studentId; }
    String getCourseCode() { return courseCode; }
    String getSemester() { return semester; }
    int getScore() { return score; }

    @Override
    public String toString() {
        return "Enrollment{" + studentId + ", " + courseCode + ", " + semester + ", " + score + "}";
    }
}

// 수강 내역 저장소입니다. 2023001(홍길동)은 CS101과 CS102 두 과목을 듣습니다.
class EnrollmentRepository {
    private static final List<Enrollment> ENROLLMENTS = List.of(
            new Enrollment(2023001, "CS101", "2023-1", 95),
            new Enrollment(2023002, "MG201", "2023-1", 88),
            new Enrollment(2023003, "CS101", "2023-1", 91),
            new Enrollment(2023004, "ME301", "2023-1", 75),
            new Enrollment(2023001, "CS102", "2023-2", 87),
            new Enrollment(2023002, "CS102", "2023-2", 93),
            new Enrollment(2023005, "CS201", "2023-2", 97));

    static List<Enrollment> getEnrollments() {
        return ENROLLMENTS;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Enrollment> enrollments = EnrollmentRepository.getEnrollments();
        System.out.println(enrollments.size()); // 7
        System.out.println(enrollments.get(0)); // Enrollment{2023001, CS101, 2023-1, 95}
    }
}
