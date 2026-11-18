// 파일 이름: Main.java
package com.codeit.collection.ch09.ex08;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<List<String>> rawData = List.of(
            List.of("Java", "Python", "Java"),
            List.of("Kotlin", "JavaScript"),
            List.of("Python", "Rust", "Go")
        );

        // 바로잡은 코드: 안쪽 리스트마다 distinct()를 먼저 쓰고 나서 펼칩니다.
        Map<String, Long> counts = rawData.stream()
            .flatMap(person -> person.stream().distinct()) // 1번 사람: [Java, Python]
            .collect(Collectors.toMap(s -> s, s -> 1L, (a, b) -> a + b));
        System.out.println(new TreeMap<>(counts));
        // {Go=1, Java=1, JavaScript=1, Kotlin=1, Python=2, Rust=1}
    }
}
