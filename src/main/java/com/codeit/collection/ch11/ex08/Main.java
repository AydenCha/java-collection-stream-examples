// 파일 이름: Main.java
package com.codeit.collection.ch11.ex08;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // 점심 메뉴 투표 결과(한 표에 메뉴 이름 하나)
        List<String> votes = List.of("김밥", "라면", "라면", "떡볶이", "라면", "떡볶이", "김밥", "순대");

        // 1) 메뉴별 표 수를 Map으로 셉니다. TreeMap이라 키(메뉴 이름) 순으로 저장됩니다.
        //    v -> v는 받은 요소를 그대로 돌려주므로, 메뉴 이름 자체가 그룹의 키가 됩니다.
        Map<String, Long> counts = votes.stream()
                .collect(Collectors.groupingBy(v -> v, TreeMap::new, Collectors.counting()));
        System.out.println(counts); // {김밥=2, 떡볶이=2, 라면=3, 순대=1}

        // 2) 정렬 기준을 만듭니다.
        //    Map.Entry.comparingByValue(비교자): 값(표 수)으로 비교하는 Comparator를 만듭니다.
        //    Comparator.reverseOrder()를 넘기면 값이 큰 것부터(내림차순) 옵니다.
        //    thenComparing(Map.Entry.comparingByKey()): 값이 같으면 키(메뉴 이름) 오름차순으로 한 번 더 정렬합니다.
        Comparator<Map.Entry<String, Long>> byCountDesc = Map.Entry.comparingByValue(Comparator.reverseOrder());
        Comparator<Map.Entry<String, Long>> order = byCountDesc.thenComparing(Map.Entry.comparingByKey());

        // 3) entrySet().stream()으로 (키, 값) 쌍을 다시 스트림으로 만들어 정렬하고, 앞의 2개만 남깁니다.
        List<Map.Entry<String, Long>> top2 = counts.entrySet().stream()
                .sorted(order)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(top2); // [라면=3, 김밥=2] (Map.Entry는 키=값 모양으로 출력됩니다)

        // 4) Map.Entry에서 키는 getKey(), 값은 getValue()로 꺼냅니다.
        for (Map.Entry<String, Long> entry : top2) {
            System.out.println(entry.getKey() + " " + entry.getValue() + "표");
        }
        // 라면 3표
        // 김밥 2표
    }
}
