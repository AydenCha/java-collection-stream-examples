// 파일 이름: Main.java
package com.codeit.collection.ch11.ex16;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

class Student {
    private final String major;

    Student(String major) {
        this.major = major;
    }

    String getMajor() { return major; }
}

class Course {
    private final String courseCode;
    private final String courseName;
    private final String professor;

    Course(String courseCode, String courseName, String professor) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.professor = professor;
    }

    String getCourseCode() { return courseCode; }
    String getCourseName() { return courseName; }
    String getProfessor() { return professor; }
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
    // 조회표에 없는 강의 코드가 와도 NullPointerException이 발생하지 않도록 이름을 찾습니다.
    static String courseName(Map<String, Course> byCode, String code) {
        Course course = byCode.get(code);
        if (course == null) {
            return "알 수 없는 강의(" + code + ")";
        }
        return course.getCourseName();
    }

    public static void main(String[] args) {
        List<Student> students = List.of(new Student("컴퓨터공학"), new Student("경영학"),
                new Student("컴퓨터공학"), new Student("기계공학"), new Student("컴퓨터공학"));
        List<Course> courses = List.of(
                new Course("CS101", "자바프로그래밍", "김철수"),
                new Course("CS102", "자료구조", "이영희"),
                new Course("MG201", "경영학원론", "박민정"),
                new Course("ME301", "열역학", "오성진"),
                new Course("CS201", "운영체제", "김철수"));
        List<Enrollment> enrollments = List.of(
                new Enrollment(2023001, "CS101", "2023-1", 95),
                new Enrollment(2023002, "MG201", "2023-1", 88),
                new Enrollment(2023003, "CS101", "2023-1", 91),
                new Enrollment(2023004, "ME301", "2023-1", 75),
                new Enrollment(2023001, "CS102", "2023-2", 87),
                new Enrollment(2023002, "CS102", "2023-2", 93),
                new Enrollment(2023005, "CS201", "2023-2", 97));

        // 4절 서비스 메서드가 돌려주는 값들입니다(여기서는 같은 스트림 코드를 바로 씁니다).
        Map<String, Course> byCode = courses.stream()
                .collect(Collectors.toMap(Course::getCourseCode, c -> c));                     // CourseService.byCode
        Map<String, Long> headcount = enrollments.stream()
                .collect(Collectors.groupingBy(Enrollment::getSemester, TreeMap::new,
                        Collectors.collectingAndThen(
                                Collectors.mapping(Enrollment::getStudentId, Collectors.toSet()),
                                ids -> (long) ids.size())));                                   // EnrollmentService.headcountBySemester
        Map<String, Double> avgByCourse = enrollments.stream()
                .collect(Collectors.groupingBy(Enrollment::getCourseCode, TreeMap::new,
                        Collectors.averagingInt(Enrollment::getScore)));                       // EnrollmentService.averageScoreByCourse
        Map<String, Long> countByMajor = students.stream()
                .collect(Collectors.groupingBy(Student::getMajor, TreeMap::new, Collectors.counting())); // StudentService.countByMajor
        Comparator<Map.Entry<String, Long>> byCountDesc = Map.Entry.comparingByValue(Comparator.reverseOrder());
        List<Map.Entry<String, Long>> top2 = enrollments.stream()
                .collect(Collectors.groupingBy(Enrollment::getCourseCode, Collectors.counting()))
                .entrySet().stream()
                .sorted(byCountDesc.thenComparing(Map.Entry.comparingByKey()))
                .limit(2)
                .collect(Collectors.toList());                                                 // EnrollmentService.topCourses(2)
        Map<String, Long> countByProfessor = courses.stream()
                .collect(Collectors.groupingBy(Course::getProfessor, TreeMap::new, Collectors.counting())); // CourseService.courseCountByProfessor

        // ReportService.fullReport(2): 줄마다 append로 이어 붙이고 마지막에 toString()으로 완성합니다.
        StringBuilder sb = new StringBuilder();
        sb.append("===== MiniLMS 리포트 =====\n");
        sb.append("학기별 수강 인원: ").append(headcount).append('\n');
        sb.append("강의별 평균 성적:\n");
        // Map.forEach((키, 값) -> ...)로 강의마다 한 줄씩 만듭니다(10장). %-8s는 강의명을 8칸에 왼쪽 정렬합니다.
        avgByCourse.forEach((code, avg) ->
                sb.append(String.format("  %s %-8s %.1f%n", code, courseName(byCode, code), avg)));
        sb.append("전공별 학생 수: ").append(countByMajor).append('\n');
        // (강의 코드, 인원) 쌍을 "강의명(인원명)"으로 바꾸고 joining(", ")으로 잇습니다.
        sb.append("인기 강의 TOP 2: ")
                .append(top2.stream()
                        .map(en -> courseName(byCode, en.getKey()) + "(" + en.getValue() + "명)")
                        .collect(Collectors.joining(", ")))
                .append('\n');
        sb.append("교수별 강의 수: ").append(countByProfessor).append('\n');
        sb.append("==========================");

        System.out.println(sb.toString());
        // ===== MiniLMS 리포트 =====
        // 학기별 수강 인원: {2023-1=4, 2023-2=3}
        // 강의별 평균 성적:
        //   CS101 자바프로그래밍  93.0
        //   CS102 자료구조     90.0
        //   CS201 운영체제     97.0
        //   ME301 열역학      75.0
        //   MG201 경영학원론    88.0
        // 전공별 학생 수: {경영학=1, 기계공학=1, 컴퓨터공학=3}
        // 인기 강의 TOP 2: 자바프로그래밍(2명), 자료구조(2명)
        // 교수별 강의 수: {김철수=2, 박민정=1, 오성진=1, 이영희=1}
        // ==========================
    }
}
