// 파일 이름: Main.java
package com.codeit.collection.ch06.ex16;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// 5장 실습의 Student와 같은 클래스입니다. 한 파일에서 실행되도록 public을 붙이지 않았습니다.
class Student {
    private final String name;
    private final int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    String getName() { return name; }
    int getScore() { return score; }
}

public class Main {
    // 5장 실습 1: 80점 이상 학생의 이름을 대문자로 모읍니다(익명 클래스 버전).
    static List<String> highScorersAnonymous(List<Student> students) {
        return students.stream()
                .filter(new Predicate<Student>() {
                    @Override
                    public boolean test(Student s) {
                        return s.getScore() >= 80;
                    }
                })
                .map(new Function<Student, String>() {
                    @Override
                    public String apply(Student s) {
                        return s.getName().toUpperCase(); // 한글은 대소문자가 없어 그대로입니다.
                    }
                })
                .collect(Collectors.toList());
    }

    // TODO 1: highScorersAnonymous와 같은 결과를 돌려주도록 filter와 map에 람다를 넘겨 완성하세요.
    static List<String> highScorersLambda(List<Student> students) {
        return new ArrayList<>(); // TODO 1: 이 줄을 스트림 코드로 바꿉니다.
    }

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("민지", 85), new Student("수현", 77),
                new Student("지훈", 90), new Student("은우", 65));

        List<String> a = highScorersAnonymous(students);
        List<String> b = highScorersLambda(students);
        System.out.println("익명 클래스: " + a);                      // 익명 클래스: [민지, 지훈]
        System.out.println("람다: " + b + " 같은가? " + a.equals(b)); // 완성 전: 람다: [] 같은가? false

        // TODO 2: 아래 익명 클래스 세 개를 람다로 바꾸세요. 출력은 그대로여야 합니다.
        List.of("김코딩", "이자바", "김스프링", "박해커").stream()
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String name) {
                        return name.startsWith("김");
                    }
                })
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String name) {
                        return name + "님";
                    }
                })
                .forEach(new Consumer<String>() {
                    @Override
                    public void accept(String name) {
                        System.out.println("인사 대상: " + name);
                    }
                });
        // 인사 대상: 김코딩님
        // 인사 대상: 김스프링님
    }
}
