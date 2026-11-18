// 파일 이름: Main.java
package com.codeit.collection.ch09.ex01;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 실습 데이터: 기술 스택을 담은 2차원 리스트
        // List 안에 List가 들어 있는 중첩 구조입니다.
        List<List<String>> rawData = List.of(
            List.of("Java", "Python", "Java"),
            List.of("Kotlin", "JavaScript"),
            List.of("Python", "Rust", "Go")
        );

        System.out.println(rawData.size());        // 3 (바깥 리스트의 요소 수 = 안쪽 리스트 3개)
        System.out.println(rawData.get(0));        // [Java, Python, Java]
        System.out.println(rawData.get(0).get(1)); // Python

        // 여기에 실습 코드를 작성합니다. 목표 출력: [Go, Java, JavaScript, Kotlin, Python, Rust]
        // (정답은 아래 "정답 예시"에 있습니다)
    }
}
