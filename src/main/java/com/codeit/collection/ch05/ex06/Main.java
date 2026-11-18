// 파일 이름: Main.java
package com.codeit.collection.ch05.ex06;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors; // collect에 넘길 수집 방법(Collectors.toList())이 들어 있습니다.

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Anna");

        // 같은 조건을 두 번 쓰므로 익명 클래스 객체를 변수에 담아 둡니다(4장).
        Predicate<String> startsWithA = new Predicate<String>() {
            @Override
            public boolean test(String name) {
                return name.startsWith("A");
            }
        };

        // count(): 남은 요소의 개수를 long으로 돌려주는 최종 연산입니다.
        long count = names.stream()
                .filter(startsWithA)
                .count();
        System.out.println(count); // 2

        // collect(Collectors.toList()): 남은 요소를 새 List에 모아 돌려주는 최종 연산입니다.
        // 스트림은 일회용이므로 위에서 쓴 스트림 대신 stream()으로 새 스트림을 만듭니다.
        List<String> result = names.stream()
                .filter(startsWithA)
                .collect(Collectors.toList());
        System.out.println(result); // [Alice, Anna]

        // 원본 리스트는 바뀌지 않습니다.
        System.out.println(names);  // [Alice, Bob, Anna]
    }
}
