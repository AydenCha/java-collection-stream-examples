// 파일 이름: Main.java
package com.codeit.collection.ch06.ex09;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        // 샘플 #1 : 실행문이 1줄이며, 그 1줄이 단순 return문인 경우
        Function<Integer, Integer> square1 = x -> {
            return x * x;
        };

        // Case #1 : return은 생략했으나 중괄호는 생략하지 않은 경우 에러 발생!
        // Function<Integer, Integer> square2 = x -> {
        //     x * x;  // 컴파일 오류: not a statement (중괄호 안에서는 완전한 문장이어야 합니다)
        // };

        // Case #2 : return도 생략, 중괄호도 생략한 경우 가능. Case #1을 바로잡은 형태입니다.
        Function<Integer, Integer> square3 = x -> x * x;

        System.out.println(square1.apply(5)); // 25
        System.out.println(square3.apply(5)); // 25
    }
}
