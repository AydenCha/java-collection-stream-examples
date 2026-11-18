// 파일 이름: Main.java
package com.codeit.collection.ch09.ex02;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> words = List.of("b", "a", "b", "c");

        // collectingAndThen(수집기, 후처리 람다)
        // (1) 첫 번째 인자인 Collectors.toList()로 먼저 리스트를 만듭니다. 여기서는 [b, a, c]입니다.
        // (2) 그 리스트가 두 번째 인자인 람다의 list로 들어갑니다.
        // (3) 람다가 돌려준 값("3개")이 collect 전체의 결과가 됩니다.
        String result = words.stream()
                .distinct()                           // 중간 연산: 중복 제거 -> b, a, c
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),          // (1) 먼저 리스트로 수집
                        list -> list.size() + "개"    // (2)(3) 수집한 리스트로 마지막 작업
                ));

        System.out.println(result); // 3개
    }
}
