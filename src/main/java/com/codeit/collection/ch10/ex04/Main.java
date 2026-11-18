// 파일 이름: Main.java
package com.codeit.collection.ch10.ex04;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
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

        // 90점 이상인 학생과 아닌 학생 분할
        System.out.println("----- partitioningBy -----");
        // partitioningBy(조건): 조건이 true인 그룹과 false인 그룹 두 개로 나눕니다.
        Map<Boolean, List<Student>> scorePartition = studentList.stream()
                .collect(Collectors.partitioningBy(student -> student.getScore() >= 90));

        System.out.println("==== 90점 이상 학생 ====");
        // get(true): 조건을 만족한 학생 리스트
        scorePartition.get(true).forEach(System.out::println);

        System.out.println("==== 90점 미만 학생 ====");
        // get(false): 조건을 만족하지 못한 학생 리스트
        scorePartition.get(false).forEach(System.out::println);
        System.out.println("--------------------------------");

        // 100점을 넘는 학생은 없습니다. 그래도 partitioningBy 결과에는 true 키가 있고 값은 빈 리스트입니다.
        Map<Boolean, List<Student>> over100 = studentList.stream()
                .collect(Collectors.partitioningBy(student -> student.getScore() > 100));
        System.out.println("partitioningBy의 true: " + over100.get(true));

        // 같은 조건을 groupingBy로 나누면 요소가 없는 true 키는 만들어지지 않아서 get(true)가 null입니다.
        Map<Boolean, List<Student>> grouped = studentList.stream()
                .collect(Collectors.groupingBy(student -> student.getScore() > 100));
        System.out.println("groupingBy의 true: " + grouped.get(true));
    }
}
