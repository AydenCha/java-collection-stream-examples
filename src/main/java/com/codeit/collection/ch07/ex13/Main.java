// 파일 이름: Main.java
package com.codeit.collection.ch07.ex13;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        // UnaryOperator<String>: (String) -> String
        // 받은 값과 같은 타입의 값을 돌려줍니다. Function<String, String>과 같은 모양입니다.
        UnaryOperator<String> toUpper = s -> s.toUpperCase();

        System.out.println(toUpper.apply("java")); // JAVA

        // BinaryOperator<Integer>: (Integer, Integer) -> Integer
        // 같은 타입 두 개를 받아 같은 타입 하나를 돌려줍니다.
        // Math.max(a, b)는 두 수 중 큰 값을 돌려줍니다. Integer 값은 오토언박싱되어 int로 계산됩니다.
        BinaryOperator<Integer> max = (a, b) -> Math.max(a, b);

        System.out.println("최댓값: " + max.apply(10, 20)); // 최댓값: 20
    }
}
