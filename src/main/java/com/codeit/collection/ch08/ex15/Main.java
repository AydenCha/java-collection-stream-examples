// 파일 이름: Main.java
package com.codeit.collection.ch08.ex15;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        /*
         * [최종 연산] toArray()
         * - 숫자 스트림(IntStream 등)은 인자 없이 호출하면 해당 타입의 배열(int[])을 반환합니다.
         * - 객체 스트림에서 인자 없이 호출하면 Object[]가 돌아옵니다.
         *   원하는 타입의 배열을 받으려면 배열을 만드는 방법을 넘겨야 합니다.
         */
        int[] arr = IntStream.rangeClosed(1, 5).toArray();
        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 4, 5]

        /*
         * String[]::new는 7장에서 본 생성자 참조의 배열 버전입니다.
         * 람다로 쓰면 size -> new String[size]이고, toArray가 요소 개수를 넘겨 배열을 만듭니다.
         */
        String[] names = Stream.of("a", "b", "c").toArray(String[]::new);
        System.out.println(Arrays.toString(names)); // [a, b, c]
    }
}
