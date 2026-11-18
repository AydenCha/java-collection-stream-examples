// 파일 이름: Main.java
package com.codeit.collection.ch05.ex08;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Anna");

        // 자주 하는 실수 1: 최종 연산을 빠뜨린다
        names.stream()
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String name) {
                        System.out.println("검사: " + name); // 한 번도 출력되지 않습니다.
                        return name.startsWith("A");
                    }
                });
        // 최종 연산이 없으므로 filter가 실행되지 않고, 결과도 어디에도 남지 않습니다.
        System.out.println("filter를 적었지만 아무 일도 일어나지 않았습니다");

        // 자주 하는 실수 2: 최종 연산을 마친 스트림을 다시 쓴다
        Stream<String> stream = names.stream();
        System.out.println(stream.count()); // 3
        try {
            System.out.println(stream.count()); // 이미 최종 연산을 한 스트림이라 예외가 발생합니다.
        } catch (IllegalStateException e) {
            System.out.println("IllegalStateException: " + e.getMessage());
            // IllegalStateException: stream has already been operated upon or closed
        }
    }
}
