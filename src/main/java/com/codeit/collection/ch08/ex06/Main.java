// 파일 이름: Main.java
package com.codeit.collection.ch08.ex06;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Eve");

        names.stream()
            // 1. 이름 길이가 3보다 큰 "Alice", "Charlie", "David"만 통과
            .filter(name -> name.length() > 3) 
            /*
             * [중간 연산] peek(Consumer)
             * - 스트림 흐름을 방해하지 않으면서 현재 요소를 '엿봅니다'.
             * - 필터링 직후 어떤 데이터가 살아남았는지 로그를 남길 때 매우 유용합니다.
             */
            .peek(name -> System.out.println("필터링 통과: " + name)) 
            // 2. 통과된 이름을 대문자로 변환 (ALICE, CHARLIE, DAVID)
            .map(String::toUpperCase) 
            // 3. 최종 출력
            .forEach(System.out::println);
    }
}
