// 파일 이름: Main.java
package com.codeit.collection.ch11.ex07;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

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

    String getCourseCode() { return courseCode; }
    String getCourseName() { return courseName; }
    String getProfessor() { return professor; }
    int getCredit() { return credit; }

    @Override
    public String toString() {
        return "Course{" + courseCode + ", " + courseName + ", " + professor + ", " + credit + "학점}";
    }
}

class CourseService {
    private final List<Course> courses;

    CourseService(List<Course> courses) {
        this.courses = courses;
    }

    // 강의 코드 -> 강의 조회표. 성적표에서 강의 코드로 강의명을 찾을 때 씁니다.
    // c -> c는 받은 Course를 그대로 값으로 씁니다(Function.identity()로 써도 같습니다).
    Map<String, Course> byCode() {
        return courses.stream().collect(Collectors.toMap(Course::getCourseCode, c -> c));
    }

    // 교수별 강의명: groupingBy + mapping
    Map<String, List<String>> courseNamesByProfessor() {
        return courses.stream()
                .collect(Collectors.groupingBy(Course::getProfessor, TreeMap::new,
                        Collectors.mapping(Course::getCourseName, Collectors.toList())));
    }

    // mapToInt로 IntStream을 만들면 sum(), average()를 바로 쓸 수 있습니다.
    int totalCredit() {
        return courses.stream().mapToInt(Course::getCredit).sum();
    }

    // average()는 OptionalDouble을 돌려줍니다. 강의가 하나도 없으면 0.0을 씁니다.
    double averageCredit() {
        return courses.stream().mapToInt(Course::getCredit).average().orElse(0.0);
    }

    // 문자열은 sorted()만 해도 사전 순(오름차순)으로 정렬됩니다.
    List<String> namesSorted() {
        return courses.stream().map(Course::getCourseName).sorted().collect(Collectors.toList());
    }

    List<Course> findByProfessor(String professor) {
        return courses.stream().filter(c -> c.getProfessor().equals(professor)).collect(Collectors.toList());
    }
}

public class Main {
    public static void main(String[] args) {
        CourseService service = new CourseService(List.of(
                new Course("CS101", "자바프로그래밍", "김철수", 3),
                new Course("CS102", "자료구조", "이영희", 3),
                new Course("MG201", "경영학원론", "박민정", 2),
                new Course("ME301", "열역학", "오성진", 3),
                new Course("CS201", "운영체제", "김철수", 3)));

        System.out.println(service.byCode().get("ME301").getCourseName()); // 열역학
        System.out.println(service.courseNamesByProfessor()); // {김철수=[자바프로그래밍, 운영체제], 박민정=[경영학원론], 오성진=[열역학], 이영희=[자료구조]}
        System.out.println(service.totalCredit());   // 14
        System.out.println(service.averageCredit()); // 2.8
        System.out.println(service.namesSorted());   // [경영학원론, 열역학, 운영체제, 자료구조, 자바프로그래밍]
        System.out.println(service.findByProfessor("김철수")); // [Course{CS101, 자바프로그래밍, 김철수, 3학점}, Course{CS201, 운영체제, 김철수, 3학점}]
    }
}
