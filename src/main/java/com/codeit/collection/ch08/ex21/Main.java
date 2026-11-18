// 파일 이름: Main.java
package com.codeit.collection.ch08.ex21;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<String> empty = Optional.empty();

        // 바로잡은 코드 1: 기본값이 있으면 orElse로 꺼냅니다. 비어 있어도 예외가 발생하지 않습니다.
        System.out.println(empty.orElse("기본값")); // 기본값

        // 바로잡은 코드 2: 값이 있을 때만 무언가 하려면 ifPresent를 씁니다.
        empty.ifPresent(v -> System.out.println("값: " + v)); // 비어 있으므로 출력 없음

        Optional<String> name = Optional.of("kimcoding");
        name.ifPresent(v -> System.out.println("값: " + v)); // 값: kimcoding
    }
}
