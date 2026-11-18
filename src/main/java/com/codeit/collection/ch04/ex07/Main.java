// 파일 이름: Main.java
package com.codeit.collection.ch04.ex07;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> fruits = List.of("Apple", "Banana", "Orange");

        Consumer<String> printer = new Consumer<String>() {
            @Override
            public void accept(String fruit) {
                System.out.println(fruit);
            }
        };

        Stream<String> stream = fruits.stream();

        // 첫 번째 사용: 최종 연산(forEach)을 실행하면 스트림이 닫힙니다.
        stream.forEach(printer); // Apple, Banana, Orange (한 줄에 하나씩)

        // 두 번째 사용: 이미 닫힌 스트림에 다시 최종 연산을 실행하면 IllegalStateException이 발생하고 프로그램이 멈춥니다.
        stream.forEach(printer);
    }
}
