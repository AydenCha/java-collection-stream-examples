// 파일 이름: Main.java
package com.codeit.collection.ch04.ex08;

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
        stream.forEach(printer);    // Apple, Banana, Orange (한 줄에 하나씩). 이 스트림은 여기서 닫힙니다.

        // 해결 방법: 원본 컬렉션에서 스트림을 새로 만듭니다. 원본 fruits는 그대로 남아 있으므로 몇 번이든 새로 만들 수 있습니다.
        Stream<String> newStream = fruits.stream();
        newStream.forEach(printer); // Apple, Banana, Orange (한 줄에 하나씩)
    }
}
