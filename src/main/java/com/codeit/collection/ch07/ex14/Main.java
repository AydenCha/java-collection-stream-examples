// 파일 이름: Main.java
package com.codeit.collection.ch07.ex14;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // Predicate<String>: (String) -> boolean
        // 조건을 검사해 true나 false만 돌려줍니다. 스트림의 filter에 넘기는 조건이 이 모양입니다.
        Predicate<String> isEmpty = str -> str == null || str.isEmpty();

        System.out.println("빈 값인가요? " + isEmpty.test("")); // 빈 값인가요? true

        // IntPredicate: (int) -> boolean
        // int 값을 Integer로 오토박싱하지 않고 그대로 받는 전용 인터페이스입니다.
        IntPredicate isEven = n -> n % 2 == 0;

        System.out.println("4는 짝수인가요? " + isEven.test(4)); // 4는 짝수인가요? true
    }
}
