package com.codeit.collection.ch09.ex06;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    // TODO 1: 사람별 기술 수를 "1번: 2개" 모양으로 (한 사람 안의 중복은 1개)
    static List<String> perPerson(List<List<String>> raw) {
        return List.of();
    }

    // TODO 2: 기술별 보유 인원 (한 사람이 두 번 적어도 1명, 키는 이름순)
    static Map<String, Long> holders(List<List<String>> raw) {
        return new TreeMap<>();
    }

    // TODO 3: 글자 수가 긴 순, 같으면 이름순으로 상위 3개를 " > "로 잇기
    static String top3ByLength(List<String> skills) {
        return "";
    }

    public static void main(String[] args) {
        List<List<String>> rawData = List.of(
            List.of("Java", "Python", "Java"),
            List.of("Kotlin", "JavaScript"),
            List.of("Python", "Rust", "Go")
        );
        List<String> skills = List.of("Go", "Java", "JavaScript", "Kotlin", "Python", "Rust"); // 1절 결과

        // 목표 출력
        // 사람별: [1번: 2개, 2번: 2개, 3번: 3개]
        // 기술별 보유 인원: {Go=1, Java=1, JavaScript=1, Kotlin=1, Python=2, Rust=1}
        // 긴 이름 TOP3: JavaScript > Kotlin > Python
        System.out.println("사람별: " + perPerson(rawData));
        System.out.println("기술별 보유 인원: " + holders(rawData));
        System.out.println("긴 이름 TOP3: " + top3ByLength(skills));
    }
}
