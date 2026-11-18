// 파일 이름: Main.java
package com.codeit.collection.ch09.ex05;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<List<String>> rawData = List.of(
            List.of("Java", "Python", "Java"),
            List.of("Kotlin", "JavaScript"),
            List.of("Python", "Rust", "Go")
        );

        // 바로잡은 코드 1: 안쪽 리스트를 펼칠 때는 flatMap을 씁니다.
        List<String> techs = rawData.stream()
            .flatMap(List::stream)                   // Stream<String>: 기술 8개가 한 줄로 이어집니다
            .collect(Collectors.toList());
        System.out.println(techs.size());            // 8
        System.out.println(techs);                   // [Java, Python, Java, Kotlin, JavaScript, Python, Rust, Go]

        // 바로잡은 코드 2: 숫자는 map으로 먼저 String으로 바꾼 뒤 joining을 씁니다.
        // String.valueOf(값)은 값을 문자열로 바꿔 돌려주는 static 메서드이고, String::valueOf는 그 메서드 참조입니다.
        List<Integer> scores = List.of(90, 85, 70);
        String line = scores.stream()
            .map(String::valueOf)                    // Stream<Integer> -> Stream<String>
            .collect(Collectors.joining(", "));
        System.out.println(line);                    // 90, 85, 70
    }
}
