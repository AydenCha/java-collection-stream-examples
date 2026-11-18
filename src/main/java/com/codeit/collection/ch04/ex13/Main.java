// 파일 이름: Main.java
package com.codeit.collection.ch04.ex13;

import java.util.Random;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // Random: 난수를 만드는 클래스입니다(java.util 패키지).
        // ints(): int 난수를 끝없이 만들어 내는 IntStream을 돌려줍니다(무한 스트림).
        IntStream stream = new Random().ints();

        // limit(5): 앞에서 5개만 남기는 중간 연산입니다(8장에서 자세히 다룹니다). limit을 빼면 출력이 끝나지 않습니다.
        // IntStream의 forEach에는 int 값을 그대로 받는 IntConsumer를 넘깁니다. 구현할 메서드는 void accept(int value)입니다.
        stream.limit(5).forEach(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value); // 실행할 때마다 다른 난수 5개가 출력됩니다.
            }
        });
    }
}
