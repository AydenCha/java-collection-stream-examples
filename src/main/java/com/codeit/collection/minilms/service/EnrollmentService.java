package com.codeit.collection.minilms.service;

import com.codeit.collection.minilms.domain.Enrollment;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 수강 내역을 받아 학생별 조회, 학기별 집계, 강의별 집계를 하는 서비스입니다.
 *
 * 작성 방법
 * - 데이터는 생성자로 받은 enrollments 목록에 들어 있습니다. 모든 메서드는 enrollments.stream()에서 시작합니다.
 * - 메서드 이름, 매개변수, 반환 타입은 정해 두었습니다. 본문만 채우면 Application에서 그대로 호출할 수 있습니다.
 * - 메서드를 하나 완성할 때마다 Application의 해당 TODO를 채우고 실행해, 주석의 예상 출력과 비교합니다.
 * - (필수) 표시가 있는 메서드를 먼저 구현합니다.
 */
public class EnrollmentService {

    private final List<Enrollment> enrollments;

    public EnrollmentService(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    /**
     * (필수) 전체 수강 내역을 돌려줍니다.
     * 힌트: 가공할 것이 없으므로 가지고 있는 목록을 그대로 돌려주면 됩니다.
     */
    public List<Enrollment> findAll() {
        // TODO: 아래 한 줄을 지우고 구현합니다.
        throw new UnsupportedOperationException("TODO: findAll() 메서드를 구현하세요.");
    }

    /**
     * (필수) 한 학생의 수강 내역을 돌려줍니다.
     * 예: findByStudent(2023001) -> 홍길동의 수강 내역 2건
     * 힌트: filter()로 학번이 같은 수강 내역만 남기고 List로 모읍니다. 학번은 long이므로 ==로 비교합니다.
     */
    public List<Enrollment> findByStudent(long studentId) {
        // TODO: 아래 한 줄을 지우고 구현합니다.
        throw new UnsupportedOperationException("TODO: findByStudent() 메서드를 구현하세요.");
    }

    /**
     * 학기별 수강 인원을 돌려줍니다. 키는 학기, 값은 그 학기에 수강한 학생 수입니다.
     * 예상 결과: {2023-1=4, 2023-2=3}
     * 힌트 1: groupingBy()로 학기별로 묶습니다. 가운데 인자로 TreeMap::new를 넘기면 키(학기) 순서로 출력됩니다(10장).
     * 힌트 2: 건수를 세려면 다운스트림에 counting()을 씁니다.
     * 더 해 보기: 한 학생이 같은 학기에 두 과목을 들으면 건수는 2이지만 인원은 1입니다.
     * 인원을 정확히 세려면 mapping()으로 학번만 꺼내 toSet()으로 모은 뒤 그 크기를 셉니다(collectingAndThen).
     */
    public Map<String, Long> headcountBySemester() {
        // TODO: 아래 한 줄을 지우고 구현합니다.
        throw new UnsupportedOperationException("TODO: headcountBySemester() 메서드를 구현하세요.");
    }

    /**
     * (필수) 강의별 평균 성적을 돌려줍니다. 키는 강의 코드, 값은 평균 점수입니다.
     * 예상 결과: {CS101=93.0, CS102=90.0, CS201=97.0, ME301=75.0, MG201=88.0}
     * 힌트: groupingBy()로 강의 코드별로 묶고, 다운스트림에 averagingInt()를 씁니다. 키 순서로 출력하려면 TreeMap::new를 넘깁니다.
     */
    public Map<String, Double> averageScoreByCourse() {
        // TODO: 아래 한 줄을 지우고 구현합니다.
        throw new UnsupportedOperationException("TODO: averageScoreByCourse() 메서드를 구현하세요.");
    }

    /**
     * 수강 인원이 많은 강의 n개를 돌려줍니다. 인원이 같으면 강의 코드 순서입니다.
     * 예상 결과(n = 2): [CS101=2, CS102=2]
     * 힌트 1: 먼저 groupingBy()와 counting()으로 강의 코드별 인원 Map을 만듭니다.
     * 힌트 2: Map은 바로 정렬할 수 없습니다. entrySet().stream()으로 (키, 값) 쌍의 스트림을 만들어 sorted(), limit(n)을 적용합니다.
     * 힌트 3: 값 내림차순은 Map.Entry.comparingByValue(Comparator.reverseOrder()), 키 오름차순은 Map.Entry.comparingByKey()입니다.
     *        두 Comparator를 thenComparing()으로 잇기 전에 Comparator<Map.Entry<String, Long>> 타입 변수에 먼저 담아야 컴파일됩니다.
     */
    public List<Map.Entry<String, Long>> topCourses(int n) {
        // TODO: 아래 한 줄을 지우고 구현합니다.
        throw new UnsupportedOperationException("TODO: topCourses() 메서드를 구현하세요.");
    }
}
