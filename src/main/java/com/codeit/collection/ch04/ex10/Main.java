// 파일 이름: Main.java
package com.codeit.collection.ch04.ex10;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String[] arr = {"김코딩", "이자바", "박해커"};

        // Stream.of(...): 배열을 넘겨도 되고, Stream.of("김코딩", "이자바")처럼 값을 바로 나열해도 됩니다.
        Stream<String> stream = Stream.of(arr);

        stream.forEach(new Consumer<String>() {
            @Override
            public void accept(String name) {
                System.out.println(name); // 김코딩, 이자바, 박해커 (한 줄에 하나씩)
            }
        });
    }
}
