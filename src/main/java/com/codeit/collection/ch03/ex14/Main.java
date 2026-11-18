// 파일 이름: Main.java
package com.codeit.collection.ch03.ex14;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /*
         * ============================================================
         * 4-2-3. List -> Map (등장 횟수 카운팅)
         * ============================================================
         *
         * getOrDefault() (3-1에서 배운 메서드):
         * - Key가 없으면 기본값 반환
         * - 있으면 기존 Value 반환
         */

        List<String> names = List.of("민지", "수현", "지훈", "민지", "수현", "민지");

        Map<String, Integer> nameCountMap = new HashMap<>();

        for (String name : names) {

            // 기존 값이 있으면 +1
            // 없으면 0 + 1
            nameCountMap.put(name, nameCountMap.getOrDefault(name, 0) + 1);
        }

        System.out.println(nameCountMap); // {지훈=1, 민지=3, 수현=2} (HashMap이라 순서는 다를 수 있습니다)

        System.out.println(nameCountMap.get("민지")); // 3
        System.out.println(nameCountMap.get("수현")); // 2
        System.out.println(nameCountMap.get("지훈")); // 1
    }
}
