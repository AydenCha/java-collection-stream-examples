package com.codeit.collection.ch05.ex11;

import java.util.List;

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
                new Student("minji", 85),
                new Student("soohyun", 77),
                new Student("jihoon", 90),
                new Student("eunwoo", 65)
        );

        System.out.println("학생 수: " + students.size()); // 학생 수: 4

        // TODO 1 (3-3): 80점 이상인 학생만 남기고, 이름을 대문자로 바꿔 출력
        // TODO 2 (3-4): 같은 결과를 List<String>으로 수집해 출력
    }
}
