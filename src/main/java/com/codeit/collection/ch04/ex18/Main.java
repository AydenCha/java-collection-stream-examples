// 파일 이름: Main.java
package com.codeit.collection.ch04.ex18;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Anna");

        names.stream()
                // map은 Function<String, Integer>를 받습니다. String을 받아 Integer를 돌려준다는 뜻입니다.
                // map이 끝나면 스트림의 요소 타입이 String에서 Integer로 바뀝니다(Stream<Integer>).
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String name) {
                        return name.length(); // int 값이 Integer로 오토박싱되어 돌아갑니다.
                    }
                })
                // 요소가 Integer로 바뀌었으므로 Consumer<Integer>를 넘깁니다.
                .forEach(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer length) {
                        System.out.println(length); // 5, 3, 4 (한 줄에 하나씩)
                    }
                });
    }
}
