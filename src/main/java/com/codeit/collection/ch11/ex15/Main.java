// 파일 이름: Main.java
package com.codeit.collection.ch11.ex15;

import java.util.Map;
import java.util.Optional;

class Course {
    private final String courseName;

    Course(String courseName) {
        this.courseName = courseName;
    }

    String getCourseName() { return courseName; }
}

public class Main {
    public static void main(String[] args) {
        // Map.of(키, 값): 수정할 수 없는 Map을 만듭니다(List.of의 Map 버전).
        Map<String, Course> byCode = Map.of("CS101", new Course("자바프로그래밍"));

        // 방법 1: getOrDefault로 없을 때 쓸 기본 객체를 정해 둡니다.
        Course unknown = new Course("알 수 없는 강의");
        System.out.println(byCode.getOrDefault("XX999", unknown).getCourseName()); // 알 수 없는 강의

        // 방법 2: Optional.ofNullable로 감싸서 있으면 이름을 꺼내고, 없으면 기본 문구를 씁니다(8장).
        String name = Optional.ofNullable(byCode.get("XX999"))
                .map(Course::getCourseName)
                .orElse("알 수 없는 강의");
        System.out.println(name); // 알 수 없는 강의

        System.out.println(byCode.getOrDefault("CS101", unknown).getCourseName()); // 자바프로그래밍
    }
}
