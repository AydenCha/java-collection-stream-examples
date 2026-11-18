// 파일 이름: Main.java
package com.codeit.collection.ch11.ex11;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> codes = List.of("CS101", "ME301", "ME301", "CS102", "ME301", "CS102");

        // 다운스트림 counting()으로 무엇을 모을지(개수) 정합니다.
        Map<String, Long> counts = codes.stream()
                .collect(Collectors.groupingBy(c -> c, TreeMap::new, Collectors.counting()));
        System.out.println(counts); // {CS101=1, CS102=2, ME301=3}

        // limit 앞에서 인원 내림차순(같으면 강의 코드 순)으로 정렬합니다.
        Comparator<Map.Entry<String, Long>> byCountDesc = Map.Entry.comparingByValue(Comparator.reverseOrder());
        List<Map.Entry<String, Long>> top2 = counts.entrySet().stream()
                .sorted(byCountDesc.thenComparing(Map.Entry.comparingByKey()))
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(top2); // [ME301=3, CS102=2]
    }
}
