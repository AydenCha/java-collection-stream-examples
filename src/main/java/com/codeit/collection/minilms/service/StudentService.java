package com.codeit.collection.minilms.service;

import com.codeit.collection.minilms.domain.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 학생 목록을 받아 조회, 검색, 그룹화를 하는 서비스입니다.
 *
 * 작성 방법
 * - 데이터는 생성자로 받은 students 목록에 들어 있습니다. 모든 메서드는 students.stream()에서 시작합니다.
 * - 메서드 이름, 매개변수, 반환 타입은 정해 두었습니다. 본문만 채우면 Application에서 그대로 호출할 수 있습니다.
 * - 메서드를 하나 완성할 때마다 Application의 해당 TODO를 채우고 실행해, 주석의 예상 출력과 비교합니다.
 * - (필수) 표시가 있는 메서드를 먼저 구현합니다.
 */
public class StudentService {

    private final List<Student> students;

    public StudentService(List<Student> students) {
        this.students = students;
    }

    /**
     * (필수) 전체 학생 목록을 학번 순서로 돌려줍니다.
     * 힌트: sorted()에 Comparator.comparingLong(Student::getStudentId)를 넘기고 List로 모읍니다.
     */
    public List<Student> findAll() {
        // TODO: 아래 한 줄을 지우고 구현합니다.
        throw new UnsupportedOperationException("TODO: findAll() 메서드를 구현하세요.");
    }

    /**
     * 학번으로 학생 한 명을 찾습니다. ReportService의 성적표에서 학생 이름을 찾을 때 씁니다.
     * 힌트: 해당 학번의 학생이 없을 수 있으므로 Optional로 돌려줍니다. filter() 뒤에 findFirst()를 쓰면 Optional이 나옵니다(8장).
     */
    public Optional<Student> findById(long studentId) {
        // TODO: 아래 한 줄을 지우고 구현합니다.
        throw new UnsupportedOperationException("TODO: findById() 메서드를 구현하세요.");
    }

    /**
     * (필수) 이름에 keyword가 들어 있는 학생을 돌려줍니다.
     * 예: searchByName("민") -> [Student{2023002, 김민지, 2학년, 경영학, 여}]
     * 힌트: filter() 안에서 String의 contains()로 검사합니다.
     */
    public List<Student> searchByName(String keyword) {
        // TODO: 아래 한 줄을 지우고 구현합니다.
        throw new UnsupportedOperationException("TODO: searchByName() 메서드를 구현하세요.");
    }

    /**
     * (필수) 학년별 학생 이름을 돌려줍니다. 키는 학년, 값은 그 학년 학생의 이름 목록입니다.
     * 예상 결과: {1=[홍길동, 이수빈], 2=[김민지, 박지현], 3=[최준영]}
     * 힌트: groupingBy()로 학년별로 묶고, 다운스트림에 mapping(Student::getName, toList())를 씁니다.
     *       가운데 인자로 TreeMap::new를 넘기면 학년 순서로 출력됩니다(10장).
     */
    public Map<Integer, List<String>> namesByGrade() {
        // TODO: 아래 한 줄을 지우고 구현합니다.
        throw new UnsupportedOperationException("TODO: namesByGrade() 메서드를 구현하세요.");
    }

    /**
     * 전공별 학생 수를 돌려줍니다.
     * 예상 결과: {경영학=1, 기계공학=1, 컴퓨터공학=3}
     * 힌트: groupingBy()로 전공별로 묶고, 다운스트림에 counting()을 씁니다. 키 순서로 출력하려면 TreeMap::new를 넘깁니다.
     */
    public Map<String, Long> countByMajor() {
        // TODO: 아래 한 줄을 지우고 구현합니다.
        throw new UnsupportedOperationException("TODO: countByMajor() 메서드를 구현하세요.");
    }

    /**
     * (옵션) 성별로 먼저 묶고, 그 안에서 전공별 학생 수를 셉니다.
     * 예상 결과: {남={기계공학=1, 컴퓨터공학=1}, 여={경영학=1, 컴퓨터공학=2}}
     * 힌트: groupingBy()의 다운스트림에 groupingBy()를 한 번 더 넣습니다. 안쪽과 바깥쪽 모두 TreeMap::new를 넘깁니다.
     */
    public Map<String, Map<String, Long>> countByGenderAndMajor() {
        // TODO: 아래 한 줄을 지우고 구현합니다.
        throw new UnsupportedOperationException("TODO: countByGenderAndMajor() 메서드를 구현하세요.");
    }

    /**
     * (옵션) 전공과 학년이 모두 같은 학생을 돌려줍니다.
     * 예: findByMajorAndGrade("컴퓨터공학", 2) -> [Student{2023005, 박지현, 2학년, 컴퓨터공학, 여}]
     * 힌트: filter()의 조건을 &&로 잇습니다. 문자열은 equals()로 비교합니다.
     */
    public List<Student> findByMajorAndGrade(String major, int grade) {
        // TODO: 아래 한 줄을 지우고 구현합니다.
        throw new UnsupportedOperationException("TODO: findByMajorAndGrade() 메서드를 구현하세요.");
    }
}
