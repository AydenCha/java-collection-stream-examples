// 파일 이름: Main.java
package com.codeit.collection.ch03.ex08;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("민지", 85);
        scores.put("지훈", 50);
        scores.put("수현", 77);

        // 점수가 60점 미만인 학생을 지웁니다.
        // 향상된 for문 안에서 scores.remove(...)를 호출하면 ConcurrentModificationException이 발생할 수 있습니다.
        // 그래서 entrySet()의 Iterator를 직접 꺼내고, Iterator의 remove()로 지금 꺼낸 항목을 지웁니다.
        Iterator<Map.Entry<String, Integer>> it = scores.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            if (entry.getValue() < 60) {
                it.remove();
            }
        }

        System.out.println(scores.size());             // 2
        System.out.println(scores.containsKey("지훈")); // false
    }
}
