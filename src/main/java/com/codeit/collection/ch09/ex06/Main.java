// 파일 이름: Main.java
package com.codeit.collection.ch09.ex06;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    // 확장 1: 사람별 기술 수 "1번: 2개" (한 사람 안의 중복은 1개)
    static List<String> perPerson(List<List<String>> raw) {
        return IntStream.range(0, raw.size())        // 0, 1, 2 (사람 번호로 쓸 인덱스)
            .mapToObj(i -> (i + 1) + "번: "           // mapToObj: int 하나를 객체(여기서는 String) 하나로 바꿉니다
                + raw.get(i).stream().distinct().count() // 안쪽 리스트에도 스트림을 한 번 더 씁니다
                + "개")
            .collect(Collectors.toList());
    }

    // 확장 2: 기술별 보유 인원 (한 사람이 두 번 적어도 1명)
    static Map<String, Long> holders(List<List<String>> raw) {
        Map<String, Long> counts = raw.stream()
            .flatMap(person -> person.stream().distinct()) // 펼치기 전에 한 사람 안의 중복부터 지웁니다
            .collect(Collectors.toMap(
                s -> s,                  // 키: 기술 이름
                s -> 1L,                 // 값: 처음 나오면 1명 (1L은 long 값 1, Long으로 오토박싱됩니다)
                (a, b) -> a + b));       // 키가 겹치면 두 값을 더합니다(8장에서 본 병합 규칙)
        return new TreeMap<>(counts);    // toMap이 돌려주는 Map은 순서를 보장하지 않으므로, TreeMap에 옮겨 키 이름순으로 맞춥니다
    }

    // 확장 3: 글자 수가 긴 순, 같으면 이름순으로 상위 3개를 " > "로 잇기
    static String top3ByLength(List<String> skills) {
        return skills.stream()
            .sorted(Comparator.comparingInt(String::length).reversed() // 1순위: 글자 수 내림차순
                .thenComparing(Comparator.naturalOrder()))             // 2순위: 글자 수가 같으면 이름의 기본 순서(사전순)
            .limit(3)                                                   // 앞에서 3개만
            .collect(Collectors.joining(" > "));                        // 구분자만 주면 앞뒤 문자 없이 잇습니다
    }

    public static void main(String[] args) {
        List<List<String>> rawData = List.of(
            List.of("Java", "Python", "Java"),
            List.of("Kotlin", "JavaScript"),
            List.of("Python", "Rust", "Go")
        );
        List<String> skills = List.of("Go", "Java", "JavaScript", "Kotlin", "Python", "Rust"); // 1절 결과

        System.out.println("사람별: " + perPerson(rawData));
        // 사람별: [1번: 2개, 2번: 2개, 3번: 3개]
        System.out.println("기술별 보유 인원: " + holders(rawData));
        // 기술별 보유 인원: {Go=1, Java=1, JavaScript=1, Kotlin=1, Python=2, Rust=1}
        System.out.println("긴 이름 TOP3: " + top3ByLength(skills));
        // 긴 이름 TOP3: JavaScript > Kotlin > Python (Kotlin과 Python은 6글자로 같아 이름순)
    }
}
