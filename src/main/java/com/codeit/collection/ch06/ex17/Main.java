// 파일 이름: Main.java
package com.codeit.collection.ch06.ex17;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
    // 비교용으로 남겨 둔 익명 클래스 버전입니다(5장 실습 1).
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
                        return s.getName().toUpperCase();
                    }
                })
                .collect(Collectors.toList());
    }

    // TODO 1 정답: 익명 클래스에서 컴파일러가 이미 아는 것(인터페이스 이름, 메서드 이름, 매개변수 타입, return)을 걷어냅니다.
    static List<String> highScorersLambda(List<Student> students) {
        return students.stream()
                .filter(s -> s.getScore() >= 80)          // new Predicate<Student>() { ... } 여섯 줄이 한 줄이 됩니다.
                .map(s -> s.getName().toUpperCase())      // new Function<Student, String>() { ... }도 한 줄입니다.
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("민지", 85), new Student("수현", 77),
                new Student("지훈", 90), new Student("은우", 65));

        List<String> a = highScorersAnonymous(students);
        List<String> b = highScorersLambda(students);
        System.out.println("익명 클래스: " + a);                      // 익명 클래스: [민지, 지훈]
        System.out.println("람다: " + b + " 같은가? " + a.equals(b)); // 람다: [민지, 지훈] 같은가? true

        // TODO 2 정답: filter, map, forEach에 넘기던 익명 클래스 세 개가 람다 세 줄이 됩니다.
        // (Consumer import도 더 이상 필요 없습니다. 람다의 타입은 forEach 선언을 보고 컴파일러가 알아냅니다)
        List.of("김코딩", "이자바", "김스프링", "박해커").stream()
                .filter(name -> name.startsWith("김"))
                .map(name -> name + "님")
                .forEach(name -> System.out.println("인사 대상: " + name));
        // 인사 대상: 김코딩님
        // 인사 대상: 김스프링님
    }
}
