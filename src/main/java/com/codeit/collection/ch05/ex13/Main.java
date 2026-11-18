// 파일 이름: Main.java
package com.codeit.collection.ch05.ex13;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors; // 빠뜨리면 Collectors를 찾을 수 없다는 컴파일 오류가 납니다.

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
         * 2) 필터링 + 변환 + 수집
         * - collect(Collectors.toList()): 스트림 결과를 List<String>으로 모읍니다.
         * - 스트림은 일회용이므로, 앞에서 한 번 쓴 스트림 대신 stream()으로 새 스트림을 만듭니다.
         * - forEach 안에서 바깥 리스트에 add하지 않고, 모을 때는 collect를 씁니다.
         */
        List<String> filteredNames = students.stream()
                .filter(new Predicate<Student>() {
                    @Override
                    public boolean test(Student student) {
                        return student.getScore() >= 80;
                    }
                })
                .map(new Function<Student, String>() {
                    @Override
                    public String apply(Student student) {
                        return student.getName().toUpperCase();
                    }
                })
                .collect(Collectors.toList());

        System.out.println("최종 명단 : " + filteredNames); // 최종 명단 : [민지, 지훈]
        System.out.println("원본 학생 수: " + students.size()); // 원본 학생 수: 4
    }
}
