// 파일 이름: Main.java
package com.codeit.collection.ch11.ex06;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

class Student {
    private final long studentId;
    private final String name;
    private final int grade;
    private final String major;
    private final String gender;

    Student(long studentId, String name, int grade, String major, String gender) {
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
        this.major = major;
        this.gender = gender;
    }

    long getStudentId() { return studentId; }
    String getName() { return name; }
    int getGrade() { return grade; }
    String getMajor() { return major; }
    String getGender() { return gender; }

    @Override
    public String toString() {
        return "Student{" + studentId + ", " + name + ", " + grade + "학년, " + major + ", " + gender + "}";
    }
}

// 학생 목록을 생성자로 받아 조회, 검색, 그룹화를 합니다. 저장소를 직접 알지 않고 받은 목록으로만 일합니다.
class StudentService {
    private final List<Student> students;

    StudentService(List<Student> students) {
        this.students = students;
    }

    // 학번 순 정렬. comparingLong은 comparingInt와 같은 방식으로 long 값을 기준으로 비교하는 Comparator를 만듭니다.
    List<Student> findAll() {
        return students.stream()
                .sorted(Comparator.comparingLong(Student::getStudentId))
                .collect(Collectors.toList());
    }

    // 없는 학번일 수 있으므로 null 대신 Optional을 돌려줍니다(8장).
    Optional<Student> findById(long studentId) {
        return students.stream().filter(s -> s.getStudentId() == studentId).findFirst();
    }

    // 이름 검색: filter + contains
    List<Student> searchByName(String keyword) {
        return students.stream()
                .filter(s -> s.getName().contains(keyword))
                .collect(Collectors.toList());
    }

    // groupingBy(기준, 결과 Map 종류, 다운스트림): 학년으로 묶고(TreeMap이라 학년 순), 값은 이름 목록
    Map<Integer, List<String>> namesByGrade() {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getGrade, TreeMap::new,
                        Collectors.mapping(Student::getName, Collectors.toList())));
    }

    // 다운스트림 counting(): 그룹마다 개수(Long)를 셉니다.
    Map<String, Long> countByMajor() {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getMajor, TreeMap::new, Collectors.counting()));
    }

    // (옵션) 다운스트림 자리에 groupingBy를 한 번 더 넣으면 2단계 그룹화가 됩니다.
    Map<String, Map<String, Long>> countByGenderAndMajor() {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getGender, TreeMap::new,
                        Collectors.groupingBy(Student::getMajor, TreeMap::new, Collectors.counting())));
    }

    // (옵션) filter를 두 번 이어 붙이면 두 조건을 모두 만족하는 요소만 남습니다.
    List<Student> findByMajorAndGrade(String major, int grade) {
        return students.stream()
                .filter(s -> s.getMajor().equals(major))
                .filter(s -> s.getGrade() == grade)
                .collect(Collectors.toList());
    }
}

public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService(List.of(
                new Student(2023001, "홍길동", 1, "컴퓨터공학", "남"),
                new Student(2023002, "김민지", 2, "경영학", "여"),
                new Student(2023003, "이수빈", 1, "컴퓨터공학", "여"),
                new Student(2023004, "최준영", 3, "기계공학", "남"),
                new Student(2023005, "박지현", 2, "컴퓨터공학", "여")));

        System.out.println(service.findAll().size());   // 5
        System.out.println(service.findById(2023003).map(Student::getName).orElse("없음")); // 이수빈
        System.out.println(service.findById(9999999).map(Student::getName).orElse("없음")); // 없음
        System.out.println(service.searchByName("민"));  // [Student{2023002, 김민지, 2학년, 경영학, 여}]
        System.out.println(service.namesByGrade());     // {1=[홍길동, 이수빈], 2=[김민지, 박지현], 3=[최준영]}
        System.out.println(service.countByMajor());     // {경영학=1, 기계공학=1, 컴퓨터공학=3}
        System.out.println(service.countByGenderAndMajor()); // {남={기계공학=1, 컴퓨터공학=1}, 여={경영학=1, 컴퓨터공학=2}}
        System.out.println(service.findByMajorAndGrade("컴퓨터공학", 2)); // [Student{2023005, 박지현, 2학년, 컴퓨터공학, 여}]
    }
}
