// 파일 이름: Main.java
package com.codeit.collection.ch10.ex03;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

// 학생 한 명: 이름, 성별, 학년, 점수
// 성별과 학년은 그룹을 나누는 기준으로, 점수는 통계를 내는 대상으로 씁니다.
class Student {
    private final String name;
    private final String gender;
    private final int grade;
    private final int score;

    Student(String name, String gender, int grade, int score) {
        this.name = name;
        this.gender = gender;
        this.grade = grade;
        this.score = score;
    }

    // getter: groupingBy(Student::getGrade)처럼 기준 값을 메서드 참조로 꺼낼 때 씁니다.
    public String getName() { return name; }
    public String getGender() { return gender; }
    public int getGrade() { return grade; }
    public int getScore() { return score; }

    // 결과를 출력했을 때 필드 값이 보이도록 toString()을 재정의합니다.
    @Override
    public String toString() {
        return "Student{name='" + name + "', gender='" + gender + "', grade=" + grade + ", score=" + score + "}";
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(
                new Student("홍길동", "남", 1, 95),
                new Student("강감찬", "남", 2, 80),
                new Student("이순신", "남", 1, 85),
                new Student("심사임당", "여", 2, 90),
                new Student("유관순", "여", 3, 100),
                new Student("문성실", "여", 1, 88)
        );

        // groupingBy(기준, 다운스트림): 두 번째 인자가 각 그룹을 무엇으로 모을지 정합니다.
        // counting()은 그룹마다 요소 개수를 셉니다. 결과 타입은 Long입니다.
        Map<String, Long> countByGender = studentList.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));
        System.out.println(countByGender.get("남")); // 3

        // 아래처럼 Integer로 받으면 컴파일 오류입니다. counting()의 결과는 Long이므로 Map<String, Long>으로 받습니다.
        // Map<String, Integer> wrong = studentList.stream()
        //         .collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));

        // averagingInt()는 그룹마다 int 값의 평균을 구합니다. 결과 타입은 Double입니다.
        Map<Integer, Double> avgByGrade = studentList.stream()
                .collect(Collectors.groupingBy(Student::getGrade, Collectors.averagingInt(Student::getScore)));
        System.out.println(avgByGrade.get(1)); // 89.33333333333333

        // 점수대(80, 90, 100)별 인원입니다. 95 / 10 * 10은 정수 나눗셈이라 90이 됩니다.
        // 기본 Map은 키 순서를 보장하지 않아서 80, 100, 90처럼 섞여 나옵니다(JDK 21에서 실행한 결과).
        Map<Integer, Long> countByRange = studentList.stream()
                .collect(Collectors.groupingBy(s -> s.getScore() / 10 * 10, Collectors.counting()));
        System.out.println(countByRange); // {80=3, 100=1, 90=2}

        // groupingBy(기준, Map 생성, 다운스트림): 가운데 인자로 결과를 담을 Map을 정합니다.
        // TreeMap::new는 7장에서 배운 생성자 참조입니다. TreeMap은 키를 오름차순으로 정렬해 둡니다.
        Map<Integer, Long> sortedCountByRange = studentList.stream()
                .collect(Collectors.groupingBy(s -> s.getScore() / 10 * 10, TreeMap::new, Collectors.counting()));
        System.out.println(sortedCountByRange); // {80=3, 90=2, 100=1}
    }
}
