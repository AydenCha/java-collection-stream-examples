// 파일 이름: Main.java
package com.codeit.collection.ch10.ex14;

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

        // reducing(초기값, 변환, 누적 규칙): 그룹마다 reduce를 합니다.
        // 각 학생을 점수로 바꾼 뒤(Student::getScore), 초기값 0에서 시작해 Integer::max로 큰 값을 남깁니다.
        Map<Integer, Integer> maxByGrade = studentList.stream()
                .collect(Collectors.groupingBy(Student::getGrade, TreeMap::new,
                        Collectors.reducing(0, Student::getScore, Integer::max)));
        System.out.println("학년별 최고 점수: " + maxByGrade); // 학년별 최고 점수: {1=95, 2=90, 3=100}

        // 누적 규칙만 Integer::sum으로 바꾸면 학년별 합계가 됩니다.
        Map<Integer, Integer> sumByGrade = studentList.stream()
                .collect(Collectors.groupingBy(Student::getGrade, TreeMap::new,
                        Collectors.reducing(0, Student::getScore, Integer::sum)));
        System.out.println("학년별 합계: " + sumByGrade); // 학년별 합계: {1=268, 2=170, 3=100}
    }
}
