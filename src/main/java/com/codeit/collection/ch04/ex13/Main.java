// 파일 이름: Main.java
package com.codeit.collection.ch04.ex13;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("민지", 90);
        scores.put("지훈", 75);
        scores.put("수현", 85);

        // Map에는 stream()이 없으므로 keySet(), values(), entrySet()으로 컬렉션을 얻은 뒤 stream()을 호출합니다.
        // keySet()은 키를 담은 Set이므로 keySet().stream()은 키의 스트림(Stream<String>)입니다.
        // count(): 요소의 개수를 long으로 돌려주는 최종 연산입니다(8-4에서 다시 씁니다).
        long keyCount = scores.keySet().stream().count();
        System.out.println("키 개수 = " + keyCount); // 키 개수 = 3

        // entrySet().stream()은 키-값 쌍(Map.Entry)의 스트림(Stream<Map.Entry<String, Integer>>)입니다.
        // 그래서 filter에 넘기는 Predicate의 꺾쇠에도 요소 타입인 Map.Entry<String, Integer>를 적습니다.
        // count는 개수만 세므로 HashMap의 순회 순서와 관계없이 결과가 같습니다.
        long passCount = scores.entrySet().stream()
                .filter(new Predicate<Map.Entry<String, Integer>>() {
                    @Override
                    public boolean test(Map.Entry<String, Integer> entry) {
                        return entry.getValue() >= 80; // 값(점수)이 80 이상인 Entry만 남깁니다.
                    }
                })
                .count();
        System.out.println("80점 이상 = " + passCount); // 80점 이상 = 2
    }
}
