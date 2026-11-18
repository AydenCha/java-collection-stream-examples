// 파일 이름: Main.java
package com.codeit.collection.ch10.ex07;

import java.util.Arrays;
import java.util.List;

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

        // average()의 결과는 OptionalDouble입니다. 아래처럼 double에 바로 담으면 컴파일 오류입니다.
        // double wrong = studentList.stream().mapToInt(Student::getScore).average();

        double average = studentList.stream()
                .mapToInt(Student::getScore)
                .average()    // 요소가 없으면 평균을 낼 수 없으므로 OptionalDouble을 돌려줍니다.
                .orElse(0.0); // 값이 있으면 그 값을, 없으면 기본값 0.0을 꺼냅니다(8장 Optional의 orElse와 같습니다).

        System.out.println("평균 점수: " + average); // 평균 점수: 89.66666666666667
    }
}
