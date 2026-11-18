// 파일 이름: Main.java
package com.codeit.collection.ch10.ex15;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
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

        // summarizingInt: 개수, 합계, 최솟값, 평균, 최댓값을 한 번에 구해 IntSummaryStatistics에 담습니다.
        IntSummaryStatistics stats = studentList.stream()
                .collect(Collectors.summarizingInt(Student::getScore));

        // 통계 객체에서 필요한 값을 메서드로 꺼냅니다.
        System.out.println("총합: " + stats.getSum());     // 총합: 538
        System.out.println("평균: " + stats.getAverage()); // 평균: 89.66666666666667
        System.out.println("최대: " + stats.getMax());     // 최대: 100
        System.out.println("최소: " + stats.getMin());     // 최소: 80
        System.out.println("개수: " + stats.getCount());   // 개수: 6

        // groupingBy의 다운스트림으로 넣으면 그룹마다 통계를 구합니다(성별 통계표).
        Map<String, IntSummaryStatistics> statsByGender = studentList.stream()
                .collect(Collectors.groupingBy(Student::getGender, TreeMap::new,
                        Collectors.summarizingInt(Student::getScore)));
        statsByGender.forEach((gender, s) ->
                System.out.println(gender + ": 평균 " + s.getAverage() + ", 최고 " + s.getMax()));
        // 남: 평균 86.66666666666667, 최고 95
        // 여: 평균 92.66666666666667, 최고 100
    }
}
