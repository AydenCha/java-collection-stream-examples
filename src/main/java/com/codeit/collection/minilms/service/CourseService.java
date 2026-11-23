package com.codeit.collection.minilms.service;

import com.codeit.collection.minilms.domain.Course;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 강의 목록을 받아 조회, 그룹화, 통계를 하는 서비스입니다.
 *
 * 작성 방법
 * - 데이터는 생성자로 받은 courses 목록에 들어 있습니다. 모든 메서드는 courses.stream()에서 시작합니다.
 * - 메서드 이름, 매개변수, 반환 타입은 정해 두었습니다. 본문만 채우면 Application에서 그대로 호출할 수 있습니다.
 * - 메서드를 하나 완성할 때마다 Application의 해당 TODO를 채우고 실행해, 주석의 예상 출력과 비교합니다.
 * - (필수) 표시가 있는 메서드를 먼저 구현합니다.
 */
public class CourseService {

    private final List<Course> courses;

    public CourseService(List<Course> courses) {
        this.courses = courses;
    }

    /**
     * (필수) 전체 강의 목록을 돌려줍니다.
     * 힌트: 가공할 것이 없으므로 가지고 있는 목록을 그대로 돌려주면 됩니다.
     */
    public List<Course> findAll() {
        // TODO: 아래 한 줄을 지우고 구현합니다.
        throw new UnsupportedOperationException("TODO: findAll() 메서드를 구현하세요.");
    }

    /**
     * 강의 코드로 강의를 바로 찾을 수 있는 조회표(Map)를 돌려줍니다. 키는 강의 코드, 값은 Course입니다.
     * ReportService가 강의 코드를 강의명으로 바꿀 때 씁니다. List를 매번 처음부터 찾지 않고 Map에서 키로 꺼내기 위한 것입니다(3장).
     * 힌트: Collectors.toMap(Course::getCourseCode, c -> c)로 모읍니다.
     */
    public Map<String, Course> byCode() {
        // TODO: 아래 한 줄을 지우고 구현합니다.
        throw new UnsupportedOperationException("TODO: byCode() 메서드를 구현하세요.");
    }

    /**
     * (필수) 교수별 강의명을 돌려줍니다. 키는 교수 이름, 값은 그 교수의 강의명 목록입니다.
     * 예상 결과: {김철수=[자바프로그래밍, 운영체제], 박민정=[경영학원론], 오성진=[열역학], 이영희=[자료구조]}
     * 힌트: groupingBy()로 교수별로 묶고, 다운스트림에 mapping(Course::getCourseName, toList())를 씁니다. 키 순서로 출력하려면 TreeMap::new를 넘깁니다.
     */
    public Map<String, List<String>> courseNamesByProfessor() {
        // TODO: 아래 한 줄을 지우고 구현합니다.
        throw new UnsupportedOperationException("TODO: courseNamesByProfessor() 메서드를 구현하세요.");
    }

    /**
     * 교수별 강의 수를 돌려줍니다. ReportService의 전체 리포트에서 씁니다.
     * 예상 결과: {김철수=2, 박민정=1, 오성진=1, 이영희=1}
     * 힌트: groupingBy()와 counting()을 씁니다. 키 순서로 출력하려면 TreeMap::new를 넘깁니다.
     */
    public Map<String, Long> courseCountByProfessor() {
        // TODO: 아래 한 줄을 지우고 구현합니다.
        throw new UnsupportedOperationException("TODO: courseCountByProfessor() 메서드를 구현하세요.");
    }

    /**
     * (필수) 전체 학점의 합계를 돌려줍니다.
     * 예상 결과: 14
     * 힌트: mapToInt(Course::getCredit)로 int 스트림을 만든 뒤 sum()을 호출합니다.
     */
    public int totalCredit() {
        // TODO: 아래 한 줄을 지우고 구현합니다.
        throw new UnsupportedOperationException("TODO: totalCredit() 메서드를 구현하세요.");
    }

    /**
     * (필수) 전체 학점의 평균을 돌려줍니다.
     * 예상 결과: 2.8
     * 힌트: mapToInt() 뒤에 average()를 호출합니다. average()는 강의가 하나도 없을 때를 대비해 OptionalDouble을 돌려주므로 orElse(0.0)으로 값을 꺼냅니다.
     */
    public double averageCredit() {
        // TODO: 아래 한 줄을 지우고 구현합니다.
        throw new UnsupportedOperationException("TODO: averageCredit() 메서드를 구현하세요.");
    }

    /**
     * 강의명을 오름차순으로 정렬해 돌려줍니다.
     * 예상 결과: [경영학원론, 열역학, 운영체제, 자료구조, 자바프로그래밍]
     * 힌트: map()으로 강의명만 꺼낸 뒤 sorted()를 호출하고 List로 모읍니다.
     */
    public List<String> namesSorted() {
        // TODO: 아래 한 줄을 지우고 구현합니다.
        throw new UnsupportedOperationException("TODO: namesSorted() 메서드를 구현하세요.");
    }

    /**
     * 한 교수가 맡은 강의를 돌려줍니다.
     * 예: findByProfessor("김철수") -> [Course{CS101, ...}, Course{CS201, ...}]
     * 힌트: filter() 안에서 교수 이름을 equals()로 비교합니다.
     */
    public List<Course> findByProfessor(String professor) {
        // TODO: 아래 한 줄을 지우고 구현합니다.
        throw new UnsupportedOperationException("TODO: findByProfessor() 메서드를 구현하세요.");
    }
}
