// 파일 이름: Main.java
package com.codeit.collection.ch08.ex07;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // 1부터 10까지 숫자가 흐르는 스트림
        IntStream.rangeClosed(1, 10)
            /*
             * [중간 연산] skip(n)
             * - 스트림의 처음부터 n개의 요소를 버립니다.
             * - 여기서는 1, 2, 3, 4, 5를 건너뛰고 6부터 스트림이 시작됩니다.
             */
            .skip(5)
            .forEach(n -> System.out.print(n + " ")); // 6 7 8 9 10
        System.out.println(); // 줄 바꿈

        IntStream.rangeClosed(1, 10)
            /*
             * [중간 연산] limit(n)
             * - 스트림의 개수를 최대 n개로 제한합니다.
             * - 1부터 10까지 숫자 중 앞의 5개(1~5)만 남기고 뒤는 잘라냅니다.
             */
            .limit(5)
            .forEach(n -> System.out.print(n + " ")); // 1 2 3 4 5
        System.out.println();

        /*
         * skip과 limit을 함께 쓰면 페이지 나누기가 됩니다.
         * 한 페이지에 size개씩 보여 줄 때 page번째 페이지는
         * 앞의 (page - 1) * size개를 건너뛰고 size개만 남기면 됩니다.
         */
        int page = 2;
        int size = 3;
        IntStream.rangeClosed(1, 10)
            .skip((page - 1) * size) // 앞의 3개(1, 2, 3)를 건너뜁니다.
            .limit(size)             // 그다음 3개만 남깁니다.
            .forEach(n -> System.out.print(n + " ")); // 4 5 6
        System.out.println();
    }
}
