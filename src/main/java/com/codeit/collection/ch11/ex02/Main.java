// 파일 이름: Main.java
package com.codeit.collection.ch11.ex02;

import java.util.List;

// 강의 하나를 나타내는 도메인 클래스입니다. 강의 코드(CS101 등)로 강의를 구분합니다.
class Course {
    private final String courseCode;
    private final String courseName;
    private final String professor;
    private final int credit;

    Course(String courseCode, String courseName, String professor, int credit) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.professor = professor;
        this.credit = credit;
    }

    // getter: 교수별 강의(groupingBy(Course::getProfessor)), 학점 합계(mapToInt(Course::getCredit))에 씁니다.
    String getCourseCode() { return courseCode; }
    String getCourseName() { return courseName; }
    String getProfessor() { return professor; }
    int getCredit() { return credit; }

    @Override
    public String toString() {
        return "Course{" + courseCode + ", " + courseName + ", " + professor + ", " + credit + "학점}";
    }
}

// 강의 저장소입니다. 실제 서비스라면 DB에서 읽어 오는 부분을 미리 만든 List로 대신합니다.
class CourseRepository {
    private static final List<Course> COURSES = List.of(
            new Course("CS101", "자바프로그래밍", "김철수", 3),
            new Course("CS102", "자료구조", "이영희", 3),
            new Course("MG201", "경영학원론", "박민정", 2),
            new Course("ME301", "열역학", "오성진", 3),
            new Course("CS201", "운영체제", "김철수", 3));

    static List<Course> getCourses() {
        return COURSES;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Course> courses = CourseRepository.getCourses();
        System.out.println(courses.size()); // 5
        System.out.println(courses.get(4)); // Course{CS201, 운영체제, 김철수, 3학점}
    }
}
