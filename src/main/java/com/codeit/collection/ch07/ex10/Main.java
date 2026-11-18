// 파일 이름: Main.java
package com.codeit.collection.ch07.ex10;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        // Consumer<String>: (String) -> void
        // 하나를 받아서 쓰고 끝냅니다. 돌려주는 값이 없습니다.
        Consumer<String> logger = log -> System.out.println("[LOG]: " + log);

        // accept(T t)를 호출하면 람다식이 실행됩니다.
        logger.accept("사용자 로그인 성공"); // [LOG]: 사용자 로그인 성공

        // BiConsumer<String, Integer>: (String, Integer) -> void
        // 두 개를 받아서 쓰고 끝냅니다. Map의 키와 값을 함께 출력할 때 같은 모양입니다.
        BiConsumer<String, Integer> scorePrinter =
                (name, score) -> System.out.println(name + "님의 점수: " + score);

        scorePrinter.accept("홍길동", 90); // 홍길동님의 점수: 90
    }
}
