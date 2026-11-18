// 파일 이름: Main.java
package com.codeit.collection.ch11.ex13;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Course {
    private final String courseCode;
    private final String courseName;

    Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    String getCourseCode() { return courseCode; }
    String getCourseName() { return courseName; }
}

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

    long getStudentId() { return studentId; }
    String getCourseCode() { return courseCode; }
    String getSemester() { return semester; }
    int getScore() { return score; }
}

public class Main {
    public static void main(String[] args) {
        List<Course> courses = List.of(new Course("CS101", "자바프로그래밍"), new Course("CS102", "자료구조"));
        List<Enrollment> enrollments = List.of(
                new Enrollment(2023001, "CS101", "2023-1", 95),
                new Enrollment(2023003, "CS101", "2023-1", 91),
                new Enrollment(2023001, "CS102", "2023-2", 87));

        // 1) 강의 코드 -> 강의 조회표를 한 번 만들어 둡니다. 수강 내역마다 강의 목록을 처음부터 찾지 않아도 됩니다.
        Map<String, Course> byCode = courses.stream()
                .collect(Collectors.toMap(Course::getCourseCode, c -> c));

        // 2) 한 학생의 수강 내역만 걸러 냅니다.
        long studentId = 2023001;
        List<Enrollment> mine = enrollments.stream()
                .filter(e -> e.getStudentId() == studentId)
                .collect(Collectors.toList());

        // 3) 한 건을 "  - 강의명(학기) 점수점" 한 줄로 바꾸고, joining("\n")으로 줄바꿈을 넣어 잇습니다.
        String lines = mine.stream()
                .map(e -> "  - " + byCode.get(e.getCourseCode()).getCourseName()
                        + "(" + e.getSemester() + ") " + e.getScore() + "점")
                .collect(Collectors.joining("\n"));

        // 4) 평균을 구하고 String.format으로 성적표 문자열을 완성합니다.
        double avg = mine.stream().mapToInt(Enrollment::getScore).average().orElse(0.0);
        String transcript = String.format("[%s 성적표]%n%s%n  평균 %.1f점", "홍길동", lines, avg);

        System.out.println(transcript);
        // [홍길동 성적표]
        //   - 자바프로그래밍(2023-1) 95점
        //   - 자료구조(2023-2) 87점
        //   평균 91.0점
    }
}
