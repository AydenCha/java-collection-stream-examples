// 파일 이름: Main.java
package com.codeit.collection.ch07.ex21;

import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("java", "spring");

        // 실수 1: 메서드 참조 뒤에 괄호를 붙임
        // names.stream().map(String::toUpperCase()).forEach(System.out::println);
        //   error: ')' or ',' expected
        // 바로잡은 코드: 메서드 참조에는 괄호를 붙이지 않습니다.
        names.stream().map(String::toUpperCase).forEach(System.out::println);
        // JAVA
        // SPRING

        // 실수 2: 이름이 같은 메서드가 여러 개라 어느 것을 참조하는지 정할 수 없음
        // Function<Integer, String> toText = Integer::toString;
        //   error: incompatible types: invalid method reference
        //     reference to toString is ambiguous
        //       both method toString(int) in Integer and method toString() in Integer match
        // 정적 메서드 toString(int)와 인스턴스 메서드 toString()이 둘 다 (Integer) -> String 모양에 맞기 때문입니다.
        // 바로잡은 코드: 람다식으로 되돌려 어느 메서드를 호출할지 직접 적습니다.
        Function<Integer, String> toText = n -> Integer.toString(n);
        System.out.println(toText.apply(42) + "점"); // 42점
    }
}
