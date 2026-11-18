// 파일 이름: Main.java
package com.codeit.collection.ch05.ex12;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class Student {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() { return name; }
    public int getScore() { return score; }

    @Override
    public String toString() {
        return name + " (" + score + "점)";
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("민지", 85),
                new Student("수현", 77),
                new Student("지훈", 90),
                new Student("은우", 65)
        );

        /*
         * 1) 필터링 + 변환 + 출력
         * - filter: 점수가 80점 이상인 Student만 통과
         * - map: Student를 String(이름)으로 바꾼 뒤 대문자로 변환
         *   (한글에는 대소문자가 없어서 결과는 그대로입니다. 영문 이름이면 대문자로 바뀝니다)
         * - forEach: 최종 연산, 각 요소를 출력
         */
        students.stream()
                // Predicate<Student>: Student를 받아 true/false를 돌려줍니다.
                .filter(new Predicate<Student>() {
                    @Override
                    public boolean test(Student student) {
                        return student.getScore() >= 80;
                    }
                })
                // Function<Student, String>: 제네릭은 <입력 타입, 결과 타입> 순서입니다.
                // 여기서부터 스트림의 요소 타입이 Student에서 String으로 바뀝니다.
                .map(new Function<Student, String>() {
                    @Override
                    public String apply(Student student) {
                        return student.getName().toUpperCase();
                    }
                })
                // map 뒤의 요소는 String이므로 Consumer<String>을 넘깁니다.
                .forEach(new Consumer<String>() {
                    @Override
                    public void accept(String name) {
                        System.out.println(name);
                    }
                });
        // 출력:
        // 민지
        // 지훈
    }
}
