// 파일 이름: Main.java
package com.codeit.collection.ch10.ex01;

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

        // 학년별로 그룹화
        System.out.println("----- groupingBy(학년) -----");
        // groupingBy(기준): 기준 값이 키, 그 키에 해당하는 학생 리스트가 값인 Map을 만듭니다.
        // 학년(int)은 오토박싱되어 Integer 키가 됩니다.
        Map<Integer, List<Student>> gradeGroupMap = studentList.stream()
                .collect(Collectors.groupingBy(Student::getGrade));
        // groupingBy가 만드는 Map은 키 순서를 보장하지 않습니다. 순서를 정하는 방법은 1-3에서 봅니다.

        // Map의 forEach()는 키와 값 두 개를 받는 람다를 받습니다(7장의 BiConsumer).
        gradeGroupMap.forEach((grade, students) -> {
            System.out.println("[ " + grade + "학년 ]");
            students.forEach(student -> System.out.println(student));
        });
        System.out.println("--------------------------------");

        // 성별로 그룹화
        System.out.println("----- groupingBy(성별) -----");
        // 같은 groupingBy에 기준만 바꿔 넘깁니다. 이번에는 성별(String)이 키입니다.
        Map<String, List<Student>> genderGroupMap = studentList.stream()
                .collect(Collectors.groupingBy(Student::getGender));

        genderGroupMap.forEach((gender, students) -> {
            System.out.println("[ " + gender + "학생 ]");
            students.forEach(student -> System.out.println(student));
        });
        System.out.println("--------------------------------");
    }
}
