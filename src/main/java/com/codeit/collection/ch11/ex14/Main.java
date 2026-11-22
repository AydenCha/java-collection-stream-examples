// 파일 이름: Main.java
package com.codeit.collection.ch11.ex14;

import java.util.Map;

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

        try {
            // 조회표에 없는 코드면 get은 null을 돌려주고, null에 getCourseName()을 호출하면 NullPointerException이 발생합니다.
            String name = byCode.get("XX999").getCourseName();
            System.out.println(name);
        } catch (NullPointerException e) {
            System.out.println("없는 강의 코드: NullPointerException"); // 없는 강의 코드: NullPointerException
        }
    }
}
