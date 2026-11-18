// 파일 이름: Main.java
package com.codeit.collection.ch11.ex10;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // 수강 신청 한 건마다 강의 코드 하나
        List<String> codes = List.of("CS101", "ME301", "ME301", "CS102", "ME301", "CS102");

        // 자주 하는 실수 1: 다운스트림을 정하지 않으면 기본값 toList()가 쓰여 값이 요소 목록(List)이 됩니다.
        // (출력 순서를 고정하려고 TreeMap과 기본값 toList()를 직접 적었습니다.)
        Map<String, List<String>> grouped = codes.stream()
                .collect(Collectors.groupingBy(c -> c, TreeMap::new, Collectors.toList()));
        System.out.println(grouped); // {CS101=[CS101], CS102=[CS102, CS102], ME301=[ME301, ME301, ME301]}

        // 자주 하는 실수 2: 정렬 없이 limit만 하면 Map에 저장된 순서(여기서는 키 순)대로 잘립니다.
        Map<String, Long> counts = codes.stream()
                .collect(Collectors.groupingBy(c -> c, TreeMap::new, Collectors.counting()));
        List<Map.Entry<String, Long>> top2 = counts.entrySet().stream()
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(top2); // [CS101=1, CS102=2] (3명이 들은 ME301이 빠졌습니다)
    }
}
