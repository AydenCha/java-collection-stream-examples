// 파일 이름: Main.java
package com.codeit.collection.ch10.ex13;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // 초기값은 결과에 영향을 주지 않는 값(항등원)이어야 합니다. 덧셈은 0, 곱셈은 1입니다.
        int product = IntStream.rangeClosed(1, 4) // 1, 2, 3, 4
                .reduce(1, (a, b) -> a * b);
        // 1 * 1 = 1, 1 * 2 = 2, 2 * 3 = 6, 6 * 4 = 24
        System.out.println(product); // 24
    }
}
