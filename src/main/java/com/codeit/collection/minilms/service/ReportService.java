package com.codeit.collection.minilms.service;

import com.codeit.collection.minilms.domain.Course;
import com.codeit.collection.minilms.domain.Enrollment;
import com.codeit.collection.minilms.domain.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * (옵션) 다른 세 서비스의 결과를 엮어 리포트 문자열을 만드는 서비스입니다.
 *
 * 작성 방법
 * - 이 서비스는 목록을 직접 갖지 않습니다. 생성자로 받은 세 서비스의 메서드를 호출해 얻은 결과를 문자열로 조립합니다.
 * - EnrollmentService, StudentService, CourseService를 먼저 완성한 뒤에 작성합니다.
 * - 여러 줄을 이어 붙일 때는 StringBuilder의 append()를 쓰고, 마지막에 toString()으로 문자열을 만듭니다.
 * - String.format("%s %d점", 이름, 점수)처럼 쓰면 자리에 값을 채운 문자열을 얻습니다. %s는 문자열, %d는 정수, %.1f는 소수 첫째 자리까지, %n은 줄바꿈입니다.
 */
public class ReportService {

    private final StudentService studentService;
    private final CourseService courseService;
    private final EnrollmentService enrollmentService;

    public ReportService(StudentService studentService, CourseService courseService,
                         EnrollmentService enrollmentService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.enrollmentService = enrollmentService;
    }

    /**
     * 한 학생의 성적표를 문자열로 돌려줍니다.
     * 예상 결과(studentId = 2023001):
     * [홍길동 성적표]
     *   - 자바프로그래밍(2023-1) 95점
     *   - 자료구조(2023-2) 87점
     *   평균 91.0점
     * 순서 1: studentService.findById()로 학생 이름을 찾습니다. Optional이므로 map(Student::getName).orElse("알 수 없는 학생")으로 꺼냅니다.
     * 순서 2: enrollmentService.findByStudent()로 이 학생의 수강 내역을 가져옵니다.
     * 순서 3: courseService.byCode()로 조회표를 한 번 만들어 두고, 수강 내역마다 강의 코드로 강의명을 찾습니다.
     * 순서 4: 수강 내역을 map()으로 "  - 강의명(학기) 점수점" 문자열로 바꾸고 Collectors.joining("\n")으로 잇습니다.
     * 순서 5: mapToInt(Enrollment::getScore).average().orElse(0.0)으로 평균을 구해 마지막 줄에 붙입니다.
     * 주의: 조회표에 없는 강의 코드로 get()을 호출하면 null이 돌아옵니다. null이면 강의명 대신 쓸 문자열을 정해 둡니다.
     */
    public String transcript(long studentId) {
        // TODO: 아래 한 줄을 지우고 구현합니다.
        throw new UnsupportedOperationException("TODO: transcript() 메서드를 구현하세요.");
    }

    /**
     * 전체 리포트를 문자열로 돌려줍니다. topN은 인기 강의를 몇 개까지 보여 줄지입니다.
     * 예상 결과(topN = 2):
     * ===== MiniLMS 리포트 =====
     * 학기별 수강 인원: {2023-1=4, 2023-2=3}
     * 강의별 평균 성적:
     *   CS101 자바프로그래밍  93.0
     *   (강의마다 한 줄씩)
     * 전공별 학생 수: {경영학=1, 기계공학=1, 컴퓨터공학=3}
     * 인기 강의 TOP 2: 자바프로그래밍(2명), 자료구조(2명)
     * 교수별 강의 수: {김철수=2, 박민정=1, 오성진=1, 이영희=1}
     * ==========================
     * 순서: 줄마다 해당 서비스 메서드(headcountBySemester, averageScoreByCourse, countByMajor, topCourses, courseCountByProfessor)를 호출해
     *       StringBuilder에 append()로 붙입니다. Map은 append()에 그대로 넘기면 {키=값} 모양으로 붙습니다.
     * 힌트 1: 강의별 평균 줄은 Map의 forEach((code, avg) -> ...) 안에서 String.format("  %s %-8s %.1f%n", 강의코드, 강의명, 평균)으로 만듭니다.
     * 힌트 2: 인기 강의 줄은 topCourses(topN)의 결과를 map()으로 "강의명(n명)" 문자열로 바꾸고 Collectors.joining(", ")으로 잇습니다.
     */
    public String fullReport(int topN) {
        // TODO: 아래 한 줄을 지우고 구현합니다.
        throw new UnsupportedOperationException("TODO: fullReport() 메서드를 구현하세요.");
    }
}
