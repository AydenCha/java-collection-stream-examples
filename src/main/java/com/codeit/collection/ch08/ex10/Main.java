// 파일 이름: Main.java
package com.codeit.collection.ch08.ex10;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Student {
    // 성별처럼 정해진 값 중 하나만 가질 수 있는 타입은 enum으로 만듭니다. Student 안에 선언했으므로 Student.Gender로 씁니다.
    enum Gender { Male, Female }

    private String name;
    private int score;
    private Gender gender;

    Student(String name, int score, Gender gender) {
        this.name = name;
        this.score = score;
        this.gender = gender;
    }

    String getName() { return name; }
    int getScore() { return score; }
    Gender getGender() { return gender; }
}

public class Main {
    public static void main(String[] args) {
        List<Student> totalList = Arrays.asList(
            new Student("김코딩", 100, Student.Gender.Male),
            new Student("박해커", 80, Student.Gender.Male),
            new Student("이자바", 90, Student.Gender.Female),
            new Student("최스프링", 60, Student.Gender.Female)
        );

        Map<String, Integer> maleMap = totalList.stream()
            // 1. 성별이 남성인 학생만 필터링 (김코딩, 박해커 통과)
            .filter(s -> s.getGender() == Student.Gender.Male)
            /*
             * [최종 연산] collect(Collectors.toMap(Key, Value))
             * - 첫 번째 인자(Student::getName): 학생의 이름을 Map의 Key로 설정
             * - 두 번째 인자(Student::getScore): 학생의 점수를 Map의 Value로 설정
             * - Key가 겹치면 IllegalStateException이 발생합니다. 겹칠 수 있으면 세 번째 인자로 합치는 규칙을 줍니다.
             */
            .collect(Collectors.toMap(Student::getName, Student::getScore));

        System.out.println(maleMap.get("김코딩")); // 100
        System.out.println(maleMap.get("박해커")); // 80
        System.out.println(maleMap.size());        // 2
    }
}
