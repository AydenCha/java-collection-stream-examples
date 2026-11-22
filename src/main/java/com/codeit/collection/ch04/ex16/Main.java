// 파일 이름: Main.java
package com.codeit.collection.ch04.ex16;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // 숫자를 줄바꿈 없이 이어서 출력하는 IntConsumer 객체
        IntConsumer printer = new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.print(value);
            }
        };

        // rangeClosed(1, 10): 1부터 10까지(끝 번호 10을 포함합니다)
        IntStream.rangeClosed(1, 10).forEach(printer);
        System.out.println(); // 12345678910

        // range(1, 10): 1부터 9까지(끝 번호 10은 포함하지 않습니다)
        IntStream.range(1, 10).forEach(printer);
        System.out.println(); // 123456789
    }
}
