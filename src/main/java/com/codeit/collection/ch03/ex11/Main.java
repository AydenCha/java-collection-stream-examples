// 파일 이름: Main.java
package com.codeit.collection.ch03.ex11;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /*
         * ============================================================
         * 4-1-3. 이름과 점수 매핑 (Map 사용)
         * ============================================================
         *
         * 요구사항:
         * - Key(이름) -> Value(점수)
         * - 이름으로 빠르게 점수 조회
         *
         * Map은 Key 기반 검색 구조입니다.
         * HashMap은 저장 순서를 보장하지 않습니다.
         */

        Map<String, Integer> scores = new HashMap<>();

        scores.put("민지", 95);
        scores.put("수현", 88);
        scores.put("지훈", 100);

        // Key로 Value 조회
        System.out.println(scores.get("수현")); // 88

        // entrySet()은 Key-Value 쌍을 함께 순회할 때 효율적입니다
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        // 출력 (HashMap이라 넣은 순서와 다릅니다)
        // 지훈 : 100
        // 민지 : 95
        // 수현 : 88
    }
}
