// 파일 이름: Main.java
package com.codeit.collection.ch10.ex12;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // 1부터 4까지 곱하려고 덧셈 때처럼 초기값 0을 넣은 경우
        int product = IntStream.rangeClosed(1, 4) // 1, 2, 3, 4
                .reduce(0, (a, b) -> a * b);
        // 0 * 1 = 0, 0 * 2 = 0 ... 초기값 0에 무엇을 곱해도 0입니다.
        System.out.println(product); // 0
    }
}
