// 파일 이름: Main.java
package com.codeit.collection.ch03.ex05;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        /*
         * ============================================================
         * Map 활용 패턴 정리 (코드 관점)
         * ============================================================
         *
         * map.keySet()   -> Key 전체 조회 (Set<K>)
         * map.values()   -> Value 전체 조회 (Collection<V>)
         * map.entrySet() -> Entry 전체 조회 (Set<Map.Entry<K,V>>)
         *
         * 순회 방법:
         * - for-each
         * - Iterator
         * - Stream API (4장부터 배웁니다)
         *
         * 핵심 메시지:
         * Map은 "Key 중심" 자료구조입니다.
         * 키로 빠르게 찾아야 할 때 먼저 고려합니다.
         */

        Map<String, Integer> map = new HashMap<>();
        map.put("피카츄", 85);
        map.put("꼬부기", 95);

        Set<String> keys = map.keySet();                          // Key 전체
        Collection<Integer> values = map.values();                // Value 전체 (Collection은 List, Set의 상위 인터페이스입니다)
        Set<Map.Entry<String, Integer>> entries = map.entrySet(); // (Key, Value) 쌍 전체

        System.out.println(keys.size());    // 2
        System.out.println(values.size());  // 2
        System.out.println(entries.size()); // 2

        // keySet()은 Map을 그대로 보여 주는 창(뷰)이고, 복사본을 따로 만들지 않습니다.
        // 그래서 Map에 새 키를 넣으면 앞에서 받아 둔 keys에도 바로 보입니다.
        map.put("파이리", 65);
        System.out.println(keys.size());    // 3

        // Iterator로 순회하는 방법 (2장에서 본 hasNext, next)
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String key = it.next();
            System.out.println(key + " = " + map.get(key));
        }
        // 출력 (HashMap이라 넣은 순서와 다를 수 있습니다)
        // 꼬부기 = 95
        // 파이리 = 65
        // 피카츄 = 85
    }
}
