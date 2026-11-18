// 파일 이름: Main.java
package com.codeit.collection.ch10.ex20;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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

        // 1학년 중 85점 이상인 학생을 점수 높은 순으로 "이름(점수)" 형태로 이어 붙입니다.
        String report = studentList.stream()
                // 두 조건을 &&로 합쳐 filter 한 번에 씁니다.
                .filter(s -> s.getGrade() == 1 && s.getScore() >= 85)
                // 8장에서 본 comparingInt로 점수 오름차순 비교 규칙을 만들고 reversed()로 뒤집습니다.
                .sorted(Comparator.comparingInt(Student::getScore).reversed())
                // 학생을 "이름(점수)" 문자열로 바꿉니다.
                .map(s -> s.getName() + "(" + s.getScore() + ")")
                // 문자열 사이에 ", "를 넣어 하나로 이어 붙입니다.
                .collect(Collectors.joining(", "));
        System.out.println("1학년 85점 이상: " + report); // 1학년 85점 이상: 홍길동(95), 문성실(88), 이순신(85)

        // filter를 두 번 이어 써도 두 조건을 모두 만족하는 학생만 남으므로 결과가 같습니다.
        String report2 = studentList.stream()
                .filter(s -> s.getGrade() == 1)
                .filter(s -> s.getScore() >= 85)
                .sorted(Comparator.comparingInt(Student::getScore).reversed())
                .map(s -> s.getName() + "(" + s.getScore() + ")")
                .collect(Collectors.joining(", "));
        System.out.println(report.equals(report2)); // true
    }
}
