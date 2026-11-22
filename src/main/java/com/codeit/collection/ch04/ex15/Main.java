// 파일 이름: Main.java
package com.codeit.collection.ch04.ex15;

import java.util.Random;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // ints(5): 처음부터 난수 5개만 만드는 IntStream을 돌려줍니다(유한 스트림).
        IntStream stream = new Random().ints(5);

        stream.forEach(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value); // 실행할 때마다 다른 난수 5개가 출력됩니다.
            }
        });
    }
}
