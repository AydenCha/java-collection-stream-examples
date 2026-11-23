package com.codeit.collection.minilms;

import com.codeit.collection.minilms.repository.CourseRepository;
import com.codeit.collection.minilms.repository.EnrollmentRepository;
import com.codeit.collection.minilms.repository.StudentRepository;
import com.codeit.collection.minilms.service.CourseService;
import com.codeit.collection.minilms.service.EnrollmentService;
import com.codeit.collection.minilms.service.ReportService;
import com.codeit.collection.minilms.service.StudentService;

/**
 * MiniLMS 종합 실습의 실행 클래스입니다. 서비스의 메서드를 호출해 결과를 출력합니다.
 *
 * 작업 순서
 * 1. domain, repository 패키지는 완성되어 있습니다. 먼저 읽어서 어떤 데이터가 있는지 확인합니다.
 * 2. service 패키지의 EnrollmentService, StudentService, CourseService에서 TODO가 적힌 메서드를 하나씩 구현합니다.
 *    메서드마다 무엇을 돌려줘야 하는지, 어떤 연산을 쓰면 되는지 주석에 적어 두었습니다.
 * 3. 메서드를 하나 구현할 때마다 이 파일의 해당 TODO를 채우고 실행해, 주석의 예상 출력과 비교합니다.
 * 4. 세 서비스를 마친 뒤 (옵션) ReportService를 구현합니다.
 *
 * 아직 구현하지 않은 메서드를 호출하면 UnsupportedOperationException이 발생하고, 메시지에 구현할 메서드 이름이 나옵니다.
 * 실행: IntelliJ에서 main 메서드를 실행하거나, 터미널에서 ./gradlew run (Windows는 gradlew.bat run)
 */
public class Application {

    public static void main(String[] args) {
        EnrollmentService enrollmentService = new EnrollmentService(EnrollmentRepository.getEnrollments());
        StudentService studentService = new StudentService(StudentRepository.getStudents());
        CourseService courseService = new CourseService(CourseRepository.getCourses());
        ReportService reportService = new ReportService(studentService, courseService, enrollmentService);

        /* 1. Enrollment 서비스 테스트 */
        System.out.println("-------------------- 1. Enrollment 서비스 테스트 --------------------");
        System.out.println("전체 수강 내역:");
        // TODO: enrollmentService.findAll()의 결과를 한 줄에 하나씩 출력합니다. 예: 목록.forEach(System.out::println);
        // 예상 출력: Enrollment{2023001, CS101, 2023-1, 95} 부터 Enrollment{2023005, CS201, 2023-2, 97} 까지 7줄

        System.out.println("\n홍길동(2023001)의 수강 내역:");
        // TODO: enrollmentService.findByStudent(2023001)의 결과를 한 줄에 하나씩 출력합니다.
        // 예상 출력:
        // Enrollment{2023001, CS101, 2023-1, 95}
        // Enrollment{2023001, CS102, 2023-2, 87}

        System.out.println("\n학기별 수강 인원:");
        // TODO: enrollmentService.headcountBySemester()의 결과를 System.out.println()으로 출력합니다.
        // 예상 출력: {2023-1=4, 2023-2=3}

        System.out.println("\n강의별 평균 성적:");
        // TODO: enrollmentService.averageScoreByCourse()의 결과를 출력합니다.
        // 예상 출력: {CS101=93.0, CS102=90.0, CS201=97.0, ME301=75.0, MG201=88.0}

        System.out.println("\nTOP 2 인기 강의:");
        // TODO: enrollmentService.topCourses(2)의 결과를 출력합니다.
        // 예상 출력: [CS101=2, CS102=2]

        /* 2. Student 서비스 테스트 */
        System.out.println("-------------------- 2. Student 서비스 테스트 --------------------");
        System.out.println("전체 학생 목록:");
        // TODO: studentService.findAll()의 결과를 한 줄에 하나씩 출력합니다.
        // 예상 출력: Student{2023001, 홍길동, 1학년, 컴퓨터공학, 남} 부터 학번 순으로 5줄

        System.out.println("\n이름에 '민'이 포함된 학생:");
        // TODO: studentService.searchByName("민")의 결과를 출력합니다.
        // 예상 출력: [Student{2023002, 김민지, 2학년, 경영학, 여}]

        System.out.println("\n학년별 그룹화:");
        // TODO: studentService.namesByGrade()의 결과를 출력합니다.
        // 예상 출력: {1=[홍길동, 이수빈], 2=[김민지, 박지현], 3=[최준영]}

        System.out.println("\n전공별 학생 수:");
        // TODO: studentService.countByMajor()의 결과를 출력합니다.
        // 예상 출력: {경영학=1, 기계공학=1, 컴퓨터공학=3}

        System.out.println("\n성별 + 전공 그룹화:");
        // TODO: (옵션) studentService.countByGenderAndMajor()의 결과를 출력합니다.
        // 예상 출력: {남={기계공학=1, 컴퓨터공학=1}, 여={경영학=1, 컴퓨터공학=2}}

        System.out.println("\n전공이 컴퓨터공학이고 2학년인 학생:");
        // TODO: (옵션) studentService.findByMajorAndGrade("컴퓨터공학", 2)의 결과를 출력합니다.
        // 예상 출력: [Student{2023005, 박지현, 2학년, 컴퓨터공학, 여}]

        /* 3. Course 서비스 테스트 */
        System.out.println("-------------------- 3. Course 서비스 테스트 --------------------");
        System.out.println("전체 강의 목록:");
        // TODO: courseService.findAll()의 결과를 한 줄에 하나씩 출력합니다.
        // 예상 출력: Course{CS101, 자바프로그래밍, 김철수, 3학점} 부터 저장소 순서대로 5줄

        System.out.println("\n교수별 강의:");
        // TODO: courseService.courseNamesByProfessor()의 결과를 출력합니다.
        // 예상 출력: {김철수=[자바프로그래밍, 운영체제], 박민정=[경영학원론], 오성진=[열역학], 이영희=[자료구조]}

        System.out.println("\n전체 학점 합계: " + "TODO"); // TODO: "TODO" 자리를 courseService.totalCredit()으로 바꿉니다. 예상 출력: 전체 학점 합계: 14

        System.out.println("\n전체 학점 평균: " + "TODO"); // TODO: "TODO" 자리를 courseService.averageCredit()으로 바꿉니다. 예상 출력: 전체 학점 평균: 2.8

        System.out.println("\n강의명 오름차순 정렬:");
        // TODO: courseService.namesSorted()의 결과를 출력합니다.
        // 예상 출력: [경영학원론, 열역학, 운영체제, 자료구조, 자바프로그래밍]

        System.out.println("\n교수 김철수의 강의:");
        // TODO: courseService.findByProfessor("김철수")의 결과를 출력합니다.
        // 예상 출력: [Course{CS101, 자바프로그래밍, 김철수, 3학점}, Course{CS201, 운영체제, 김철수, 3학점}]

        /* 4. Report 서비스 테스트 */
        System.out.println("-------------------- 4. Report 서비스 테스트 --------------------");
        System.out.println("리포트 생성:");
        // TODO: (옵션) reportService.transcript(2023001)과 reportService.fullReport(2)의 결과를 차례로 출력합니다.
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
