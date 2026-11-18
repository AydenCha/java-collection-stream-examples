// 파일 이름: Main.java
package com.codeit.collection.ch09.ex07;

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

        // 자주 하는 실수: 한 사람 안의 중복을 지우지 않고 바로 펼친다
        Map<String, Long> counts = rawData.stream()
            .flatMap(List::stream)                   // 1번 사람이 적은 Java 두 개가 그대로 남습니다
            .collect(Collectors.toMap(s -> s, s -> 1L, (a, b) -> a + b));
        System.out.println(new TreeMap<>(counts));
        // {Go=1, Java=2, JavaScript=1, Kotlin=1, Python=2, Rust=1} (Java를 가진 사람은 1명인데 2로 셉니다)
    }
}
