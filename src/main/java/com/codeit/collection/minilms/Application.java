package com.codeit.collection.minilms;

import com.codeit.collection.minilms.repository.CourseRepository;
import com.codeit.collection.minilms.repository.EnrollmentRepository;
import com.codeit.collection.minilms.repository.StudentRepository;
import com.codeit.collection.minilms.service.CourseService;
import com.codeit.collection.minilms.service.EnrollmentService;
import com.codeit.collection.minilms.service.ReportService;
import com.codeit.collection.minilms.service.StudentService;

public class Application {

    public static void main(String[] args) {
        EnrollmentService enrollmentService = new EnrollmentService(EnrollmentRepository.getEnrollments());
        StudentService studentService = new StudentService(StudentRepository.getStudents());
        CourseService courseService = new CourseService(CourseRepository.getCourses());
        ReportService reportService = new ReportService(studentService, courseService, enrollmentService);

        /* 1. Enrollment 서비스 테스트 */
        System.out.println("-------------------- 1. Enrollment 서비스 테스트 --------------------");
        System.out.println("전체 수강 내역:");
        // TODO: 서비스 호출
        // 예상 출력: Enrollment{2023001, CS101, 2023-1, 95} 부터 Enrollment{2023005, CS201, 2023-2, 97} 까지 7줄

        System.out.println("\n홍길동(2023001)의 수강 내역:");
        // TODO: 서비스 호출
        // 예상 출력:
        // Enrollment{2023001, CS101, 2023-1, 95}
        // Enrollment{2023001, CS102, 2023-2, 87}

        System.out.println("\n학기별 수강 인원:");
        // TODO: 서비스 호출
        // 예상 출력: {2023-1=4, 2023-2=3}

        System.out.println("\n강의별 평균 성적:");
        // TODO: 서비스 호출
        // 예상 출력: {CS101=93.0, CS102=90.0, CS201=97.0, ME301=75.0, MG201=88.0}

        System.out.println("\nTOP 2 인기 강의:");
        // TODO: 서비스 호출
        // 예상 출력: [CS101=2, CS102=2]

        /* 2. Student 서비스 테스트 */
        System.out.println("-------------------- 2. Student 서비스 테스트 --------------------");
        System.out.println("전체 학생 목록:");
        // TODO: 서비스 호출
        // 예상 출력: Student{2023001, 홍길동, 1학년, 컴퓨터공학, 남} 부터 학번 순으로 5줄

        System.out.println("\n이름에 '민'이 포함된 학생:");
        // TODO: 서비스 호출
        // 예상 출력: [Student{2023002, 김민지, 2학년, 경영학, 여}]

        System.out.println("\n학년별 그룹화:");
        // TODO: 서비스 호출
        // 예상 출력: {1=[홍길동, 이수빈], 2=[김민지, 박지현], 3=[최준영]}

        System.out.println("\n전공별 학생 수:");
        // TODO: 서비스 호출
        // 예상 출력: {경영학=1, 기계공학=1, 컴퓨터공학=3}

        System.out.println("\n성별 + 전공 그룹화:");
        // TODO: 서비스 호출
        // 예상 출력: {남={기계공학=1, 컴퓨터공학=1}, 여={경영학=1, 컴퓨터공학=2}}

        System.out.println("\n전공이 컴퓨터공학이고 2학년인 학생:");
        // TODO: 서비스 호출
        // 예상 출력: [Student{2023005, 박지현, 2학년, 컴퓨터공학, 여}]

        /* 3. Course 서비스 테스트 */
        System.out.println("-------------------- 3. Course 서비스 테스트 --------------------");
        System.out.println("전체 강의 목록:");
        // TODO: 서비스 호출
        // 예상 출력: Course{CS101, 자바프로그래밍, 김철수, 3학점} 부터 저장소 순서대로 5줄

        System.out.println("\n교수별 강의:");
        // TODO: 서비스 호출
        // 예상 출력: {김철수=[자바프로그래밍, 운영체제], 박민정=[경영학원론], 오성진=[열역학], 이영희=[자료구조]}

        System.out.println("\n전체 학점 합계: " + "TODO: 서비스 호출"); // 예상 출력: 전체 학점 합계: 14

        System.out.println("\n전체 학점 평균: " + "TODO: 서비스 호출"); // 예상 출력: 전체 학점 평균: 2.8

        System.out.println("\n강의명 오름차순 정렬:");
        // TODO: 서비스 호출
        // 예상 출력: [경영학원론, 열역학, 운영체제, 자료구조, 자바프로그래밍]

        System.out.println("\n교수 김철수의 강의:");
        // TODO: 서비스 호출
        // 예상 출력: [Course{CS101, 자바프로그래밍, 김철수, 3학점}, Course{CS201, 운영체제, 김철수, 3학점}]

        /* 4. Report 서비스 테스트 */
        System.out.println("-------------------- 4. Report 서비스 테스트 --------------------");
        System.out.println("리포트 생성:");
        // TODO: 서비스 호출(홍길동의 성적표, TOP 2를 넣은 전체 리포트)
        // 예상 출력:
        // [홍길동 성적표]
        //   - 자바프로그래밍(2023-1) 95점
        //   - 자료구조(2023-2) 87점
        //   평균 91.0점
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
