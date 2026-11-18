// 파일 이름: Main.java
package com.codeit.collection.ch08.ex05;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<String>> nestedList = Arrays.asList(
            Arrays.asList("JAVA", "SPRING"),
            Arrays.asList("java", "spring")
        );

        nestedList.stream()
            /*
             * [중간 연산] flatMap(Function)
             * - 바깥 스트림의 요소 하나하나는 List<String>입니다.
             * - List::stream으로 각 List<String>을 Stream<String>으로 바꾸고,
             * - flatMap은 이렇게 나온 여러 개의 스트림을 하나의 스트림으로 이어 붙입니다.
             * - 결과적으로 [[JAVA, SPRING], [java, spring]]이 JAVA, SPRING, java, spring으로 펼쳐집니다.
             * - map(List::stream)을 쓰면 요소가 스트림인 스트림(Stream<Stream<String>>)이 되어 펼쳐지지 않습니다.
             */
            // .flatMap(list -> list) // 컴파일 오류: flatMap에 넘기는 함수는 Stream을 돌려줘야 하는데 List를 돌려줍니다.
            .flatMap(List::stream)
            .forEach(System.out::println);
    }
}
