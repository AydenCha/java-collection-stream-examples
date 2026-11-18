// 파일 이름: Main.java
package com.codeit.collection.ch03.ex03;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /*
         * ============================================================
         * 전체 동작 예제
         * ============================================================
         *
         * keySet():
         * - 모든 Key를 Set 형태로 반환
         * - Key 중심 순회에 적합
         *
         * entrySet():
         * - Key-Value 쌍 전체 반환
         * - Map 순회의 표준 방식
         */

        Map<String, Integer> map = new HashMap<>();

        map.put("피카츄", 85);
        map.put("꼬부기", 95);
        map.put("야도란", 75);
        map.put("파이리", 65);
        map.put("피존투", 15);

        // 1. keySet() 기반 순회
        // Key를 기준으로 Value를 조회
        // (Key마다 get을 한 번 더 호출하므로, 값까지 필요하면 아래 entrySet 방식이 낫습니다)
        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }

        // 2. entrySet() 기반 순회
        // Key와 Value를 동시에 접근 (권장 방식)
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        // 출력 (HashMap이라 넣은 순서와 다릅니다. 두 순회의 순서는 서로 같습니다)
        // 야도란 : 75
        // 꼬부기 : 95
        // 파이리 : 65
        // 피카츄 : 85
        // 피존투 : 15
        // 야도란 = 75
        // 꼬부기 = 95
        // 파이리 = 65
        // 피카츄 = 85
        // 피존투 = 15
    }
}
