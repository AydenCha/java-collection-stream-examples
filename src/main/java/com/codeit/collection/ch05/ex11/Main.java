// 파일 이름: Main.java
package com.codeit.collection.ch05.ex11;

import java.util.List;

/*
 * 학생(Student) 클래스
 * - 이름(name)과 점수(score)를 함께 관리합니다.
 * - 스트림 실습에서 filter와 map의 대상이 됩니다.
 * - Main과 같은 파일에 두므로 public을 붙이지 않습니다.
 */
class Student {

    private String name;  // 학생 이름
    private int score;    // 학생 점수

    // 생성자: name, score를 받아 객체를 초기화합니다.
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // getter: filter 조건(getScore())과 map 변환(getName())에서 씁니다.
    public String getName() { return name; }
    public int getScore() { return score; }

    // toString()을 재정의하면 객체를 출력할 때 "민지 (85점)" 형태로 보입니다.
    @Override
    public String toString() {
        return name + " (" + score + "점)";
    }
}

public class Main {
    public static void main(String[] args) {
        /*
         * 스트림을 만들 데이터 소스를 준비합니다.
         * - List.of(...)는 요소를 바꿀 수 없는 리스트를 만듭니다.
         * - 스트림은 원본을 바꾸지 않으므로(읽기 전용) 이런 리스트로도 충분합니다.
         */
        List<Student> students = List.of(
                new Student("민지", 85),
                new Student("수현", 77),
                new Student("지훈", 90),
                new Student("은우", 65)
        );

        System.out.println("학생 수: " + students.size()); // 학생 수: 4

        // TODO 1 (3-3): 80점 이상인 학생만 남기고, 이름을 대문자로 바꿔 출력
        // TODO 2 (3-4): 같은 결과를 List<String>으로 수집해 출력
    }
}
