// 파일 이름: Main.java
package com.codeit.collection.ch06.ex07;

import java.util.function.BinaryOperator;

public class Main {
    public static void main(String[] args) {
        // 매개변수가 2개 이상일 때는 소괄호를 작성해야 합니다(생략 불가).
        // BinaryOperator<Integer>: Integer 두 개를 받아 Integer 하나를 돌려주는 인터페이스입니다. apply(a, b)로 실행합니다.
        BinaryOperator<Integer> sum = (a, b) -> a + b;

        System.out.println(sum.apply(10, 20)); // 30
    }
}
