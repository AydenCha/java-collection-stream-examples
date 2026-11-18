// 파일 이름: Main.java
package com.codeit.collection.ch08.ex02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Tiger", "Lion", "Monkey", "Duck", "Horse", "Cow");

        // 방법 A: 기본 오름차순 정렬 (알파벳 순)
        list.stream()
            /*
             * [중간 연산] sorted()
             * - 요소들이 Comparable 인터페이스를 구현하고 있어야 하며, 기본적으로 오름차순 정렬을 수행합니다.
             * - String은 Comparable을 구현하고 있어서 알파벳 순으로 정렬됩니다.
             */
            .sorted()
            .forEach(System.out::println);

        System.out.println("---");

        // 방법 B: 사용자 정의 정렬 (내림차순)
        list.stream()
            /*
             * [중간 연산] sorted(Comparator)
             * - Comparator의 추상 메서드는 compare(a, b) 하나뿐이라서 람다로 바로 쓸 수 있습니다.
             * - 반환값이 음수면 a가 앞, 양수면 b가 앞에 옵니다.
             * - (s1, s2) -> s2.compareTo(s1): 두 값의 순서를 바꿔 비교하므로 내림차순이 됩니다.
             */
            .sorted((s1, s2) -> s2.compareTo(s1))
            .forEach(System.out::println);

        System.out.println("---");

        // 방법 C: Comparator가 미리 만들어 둔 기준 쓰기
        list.stream()
            /*
             * Comparator.reverseOrder(): 기본 정렬(Comparable)의 반대 순서를 돌려줍니다.
             * 방법 B와 결과가 같고, 람다를 직접 쓰지 않아도 되어 읽기 쉽습니다.
             */
            .sorted(Comparator.reverseOrder())
            .forEach(System.out::println);
    }
}

/*
실행 결과
Cow
Duck
Horse
Lion
Monkey
Tiger
---
Tiger
Monkey
Lion
Horse
Duck
Cow
---
Tiger
Monkey
Lion
Horse
Duck
Cow
*/
