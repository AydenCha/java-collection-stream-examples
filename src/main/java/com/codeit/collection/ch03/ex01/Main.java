// 파일 이름: Main.java
package com.codeit.collection.ch03.ex01;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /*
         * ============================================================
         * HashMap 기본 사용 예시
         * ============================================================
         *
         * Map의 핵심 개념:
         * - Key-Value 쌍으로 저장
         * - Key는 중복 불가
         * - Value는 중복 가능
         * - HashMap은 저장 순서를 보장하지 않음
         *
         * 내부적으로 해시 기반 구조를 사용하여
         * Key의 hashCode()로 저장 위치를 빠르게 찾습니다(2장의 HashSet과 같은 원리).
         */

        // Map<Key 타입, Value 타입>: 이름(String)으로 점수(Integer)를 찾는 Map입니다.
        Map<String, Integer> scores = new HashMap<>();

        // put(K, V)
        // - 새로운 Key이면 저장하고 null을 반환(이전 Value가 없으므로)
        // - 기존 Key이면 Value를 덮어쓰고 이전 Value를 반환
        scores.put("Alice", 90);
        scores.put("Bob", 85);
        scores.put("Charlie", 92);

        // 같은 Key로 다시 put하면 Value가 바뀌고, 이전 Value를 돌려줍니다.
        // 돌려받는 값은 Integer 객체입니다(1장의 래퍼 클래스).
        Integer before = scores.put("Bob", 88);
        System.out.println(before); // 85

        // get(key)
        // - 해당 Key에 매핑된 Value 반환
        System.out.println(scores.get("Alice")); // 90

        // containsKey(key)
        // - Key 존재 여부 확인
        System.out.println(scores.containsKey("Bob")); // true

        // containsValue(value)
        // - Value 존재 여부 확인 (모든 Value를 차례로 확인하므로 Key로 찾는 것보다 느림)
        System.out.println(scores.containsValue(100)); // false

        // remove(key)
        // - 해당 Key-Value 쌍 제거
        scores.remove("Charlie");

        // Map을 그대로 출력하면 {키=값, 키=값} 모양으로 나옵니다.
        // HashMap은 순서를 보장하지 않으므로 넣은 순서(Alice, Bob)와 다르게 나올 수 있습니다.
        System.out.println(scores); // {Bob=88, Alice=90}
    }
}
