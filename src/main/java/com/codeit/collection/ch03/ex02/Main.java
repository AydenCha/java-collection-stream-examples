// 파일 이름: Main.java
package com.codeit.collection.ch03.ex02;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /*
         * ============================================================
         * Map.Entry를 이용한 반복 순회
         * ============================================================
         *
         * entrySet():
         * - 모든 Key-Value 쌍을 Entry 형태로 반환
         * - 키와 값을 함께 쓸 때 효율적인 순회 방법
         */

        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 90);
        scores.put("Bob", 85);

        // Map.Entry<String, Integer>: 키(String)와 값(Integer)을 묶은 한 쌍의 타입입니다.
        // 향상된 for문으로 entrySet()의 Entry를 하나씩 꺼냅니다.
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {

            // Entry 하나는 (Key, Value) 한 쌍을 의미
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        // 출력 (HashMap이라 넣은 순서와 다를 수 있습니다)
        // Bob : 85
        // Alice : 90
    }
}
