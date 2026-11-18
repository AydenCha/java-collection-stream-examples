// 파일 이름: Main.java
package com.codeit.collection.ch06.ex10;

import java.util.function.BinaryOperator;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        // 실수 1: 매개변수가 두 개인데 소괄호를 뺀다
        // BinaryOperator<Integer> sum = a, b -> a + b;   // 컴파일 오류: ';' expected
        // 바로잡은 코드: 매개변수가 두 개 이상이면 소괄호로 감쌉니다.
        BinaryOperator<Integer> sum = (a, b) -> a + b;

        // 실수 2: 중괄호 없이 return을 쓴다
        // Function<String, String> echo = s -> return s; // 컴파일 오류: illegal start of expression
        // 바로잡은 코드: 한 줄 식이면 return도 함께 뺍니다.
        Function<String, String> echo = s -> s;

        // 실수 3: 중괄호로 감싼 여러 줄 본문에서 return을 빠뜨린다
        // Function<Integer, Integer> twice = x -> {
        //     int result = x * 2;
        // };  // 컴파일 오류: bad return type in lambda expression (값을 돌려주지 않습니다)
        // 바로잡은 코드: 중괄호를 쓰면 return으로 값을 돌려줍니다.
        Function<Integer, Integer> twice = x -> {
            int result = x * 2;
            return result;
        };

        System.out.println(sum.apply(1, 2));   // 3
        System.out.println(echo.apply("hi"));  // hi
        System.out.println(twice.apply(5));    // 10
    }
}
