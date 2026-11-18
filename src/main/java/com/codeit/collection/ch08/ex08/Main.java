// 파일 이름: Main.java
package com.codeit.collection.ch08.ex08;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // 기본 리스트 수집 방식입니다.
        List<String> list = Stream.of("A", "B", "C")
            /*
             * [최종 연산] collect(Collectors.toList())
             * - 스트림의 요소들을 새로운 List에 담아 반환합니다.
             */
            .collect(Collectors.toList());

        System.out.println(list); // [A, B, C]
    }
}
