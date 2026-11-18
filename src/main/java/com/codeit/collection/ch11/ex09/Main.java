// 파일 이름: Main.java
package com.codeit.collection.ch11.ex09;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

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

    @Override
    public String toString() {
        return "Enrollment{" + studentId + ", " + courseCode + ", " + semester + ", " + score + "}";
    }
}

class EnrollmentService {
    private final List<Enrollment> enrollments;

    EnrollmentService(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    List<Enrollment> findByStudent(long studentId) {
        return enrollments.stream()
                .filter(e -> e.getStudentId() == studentId)
                .collect(Collectors.toList());
    }

    // 학기별 수강 인원: 학번을 Set으로 모아 중복을 없앤 뒤(collectingAndThen의 첫 인자),
    // 그 크기를 값으로 씁니다(두 번째 인자). 한 학생이 한 학기에 두 과목을 들어도 1명입니다.
    Map<String, Long> headcountBySemester() {
        return enrollments.stream()
                .collect(Collectors.groupingBy(Enrollment::getSemester, TreeMap::new,
                        Collectors.collectingAndThen(
                                Collectors.mapping(Enrollment::getStudentId, Collectors.toSet()),
                                ids -> (long) ids.size())));
    }

    // 학기별 수강 건수: 같은 학생이라도 과목 수만큼 셉니다.
    Map<String, Long> enrollmentCountBySemester() {
        return enrollments.stream()
                .collect(Collectors.groupingBy(Enrollment::getSemester, TreeMap::new, Collectors.counting()));
    }

    // 강의별 평균 성적: 다운스트림 averagingInt는 평균을 Double로 돌려줍니다.
    Map<String, Double> averageScoreByCourse() {
        return enrollments.stream()
                .collect(Collectors.groupingBy(Enrollment::getCourseCode, TreeMap::new,
                        Collectors.averagingInt(Enrollment::getScore)));
    }

    // 인기 강의 TOP N: 강의별 인원을 센 뒤, (강의 코드, 인원) 쌍을 인원 내림차순, 같으면 강의 코드 순으로 정렬해 n개만 남깁니다.
    List<Map.Entry<String, Long>> topCourses(int n) {
        Map<String, Long> counts = enrollments.stream()
                .collect(Collectors.groupingBy(Enrollment::getCourseCode, Collectors.counting()));

        Comparator<Map.Entry<String, Long>> byCountDesc = Map.Entry.comparingByValue(Comparator.reverseOrder());
        Comparator<Map.Entry<String, Long>> order = byCountDesc.thenComparing(Map.Entry.comparingByKey());

        return counts.entrySet().stream()
                .sorted(order)
                .limit(n)
                .collect(Collectors.toList());
    }
}

public class Main {
    public static void main(String[] args) {
        List<Enrollment> data = List.of(
                new Enrollment(2023001, "CS101", "2023-1", 95),
                new Enrollment(2023002, "MG201", "2023-1", 88),
                new Enrollment(2023003, "CS101", "2023-1", 91),
                new Enrollment(2023004, "ME301", "2023-1", 75),
                new Enrollment(2023001, "CS102", "2023-2", 87),
                new Enrollment(2023002, "CS102", "2023-2", 93),
                new Enrollment(2023005, "CS201", "2023-2", 97));
        EnrollmentService service = new EnrollmentService(data);

        System.out.println(service.findByStudent(2023001)); // [Enrollment{2023001, CS101, 2023-1, 95}, Enrollment{2023001, CS102, 2023-2, 87}]
        System.out.println(service.headcountBySemester());  // {2023-1=4, 2023-2=3}
        System.out.println(service.averageScoreByCourse()); // {CS101=93.0, CS102=90.0, CS201=97.0, ME301=75.0, MG201=88.0}
        System.out.println(service.topCourses(2));          // [CS101=2, CS102=2]

        // 수강 건수와 인원의 차이: 홍길동(2023001)이 2023-1에 한 과목을 더 들으면 건수는 늘고 인원은 그대로입니다.
        // 원본(List.of)은 수정할 수 없으므로 복사한 목록에 추가합니다.
        List<Enrollment> more = new ArrayList<>(data);
        more.add(new Enrollment(2023001, "MG201", "2023-1", 80));
        EnrollmentService moreService = new EnrollmentService(more);
        System.out.println(moreService.enrollmentCountBySemester()); // {2023-1=5, 2023-2=3}
        System.out.println(moreService.headcountBySemester());       // {2023-1=4, 2023-2=3}
    }
}
