// 파일 이름: Main.java
package com.codeit.collection.ch10.ex05;

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

        // 학년별로 그룹화한 뒤 성별로 다시 그룹화
        System.out.println("----- 다중 레벨 그룹화 -----");
        // 중첩 Map 구조: Map<학년, Map<성별, 학생 리스트>>
        Map<Integer, Map<String, List<Student>>> gradeAndGenderMap = studentList.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,                        // 1차 그룹화: 학년
                        Collectors.groupingBy(Student::getGender) // 2차 그룹화: 같은 학년 안에서 성별
                ));

        // 바깥 Map(학년)의 항목마다 안쪽 Map(성별)을 다시 순회합니다.
        gradeAndGenderMap.forEach((grade, genderMap) -> {
            System.out.println("[ " + grade + "학년 ]");
            genderMap.forEach((gender, students) -> {
                System.out.println("- " + gender + "학생:");
                students.forEach(student ->
                        System.out.println("  " + student.getName() + " (" + student.getScore() + "점)"));
            });
        });
        System.out.println("--------------------------------");
    }
}
