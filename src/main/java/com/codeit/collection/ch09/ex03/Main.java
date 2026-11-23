package com.codeit.collection.ch09.ex03;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<List<String>> rawData = List.of(
            List.of("Java", "Python", "Java"),
            List.of("Kotlin", "JavaScript"),
            List.of("Python", "Rust", "Go")
        );

        // TODO 1: 펼치기 -> 중복 제거 -> 정렬 -> List<String>으로 수집 (1-2)
        List<String> techList = List.of();

        // TODO 2: techList를 "[a, b, c]" 모양의 문자열로 포맷팅 (2-2)
        String formatted = "";

        // TODO 3: TODO 1과 TODO 2를 collect 한 번으로 합치기 (2-3)
        String oneShot = "";

        // 목표 출력
        // 결과 리스트: [Go, Java, JavaScript, Kotlin, Python, Rust]
        // 포맷팅 결과: [Go, Java, JavaScript, Kotlin, Python, Rust]
        // 하나로 합친 결과: [Go, Java, JavaScript, Kotlin, Python, Rust]
        System.out.println("결과 리스트: " + techList);
        System.out.println("포맷팅 결과: " + formatted);
        System.out.println("하나로 합친 결과: " + oneShot);
    }
}
