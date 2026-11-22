// 파일 이름: Main.java
// 컬렉션끼리 서로 바꾸는 예제입니다. Map의 put, get은 3장에서 자세히 배웁니다.
package com.codeit.collection.ch01.ex12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // 1) List -> Set: 중복 제거
        // List.of(...): 나열한 값으로 List를 만듭니다. 같은 값을 여러 번 적어도 됩니다.
        List<String> list = List.of("a", "b", "a");
        Set<String> set = new HashSet<>(list);   // List를 넘겨 Set을 만들면 중복된 "a"가 하나만 남습니다.
        System.out.println(set.size()); // 2

        // 2) Set -> List: 순서 부여
        // Set은 인덱스가 없지만 List로 옮기면 get(0)처럼 위치로 꺼낼 수 있습니다.
        List<String> fromSet = new ArrayList<>(set);
        System.out.println(fromSet.size()); // 2

        // 3) Set -> Map: 요소를 key로, 가공한 결과를 value로
        // Set.of(...): 나열한 값으로 Set을 만듭니다.
        Set<String> fruits = Set.of("apple", "banana");
        // Map<String, Integer>: key 타입은 String, value 타입은 Integer입니다.
        Map<String, Integer> fruitMap = new HashMap<>();
        for (String fruit : fruits) {               // Set도 Iterable이므로 향상된 for 문을 쓸 수 있습니다.
            fruitMap.put(fruit, fruit.length());   // 과일 이름을 key로, 글자 수를 value로 넣습니다.
        }
        System.out.println(fruitMap.get("apple"));  // 5
        System.out.println(fruitMap.get("banana")); // 6

        // 4) Map -> Set: keySet()
        // keySet()은 Map의 key만 모아 Set으로 돌려줍니다. key는 중복될 수 없으므로 Set과 성질이 맞습니다.
        Set<String> keys = fruitMap.keySet();
        System.out.println(keys.contains("apple")); // true

        // 5) List -> Map: 인덱스를 key로
        List<String> names = List.of("민지", "지훈");
        Map<Integer, String> byIndex = new HashMap<>();
        for (int i = 0; i < names.size(); i++) {
            byIndex.put(i, names.get(i));   // 0 -> 민지, 1 -> 지훈
        }
        System.out.println(byIndex.get(1)); // 지훈
    }
}
