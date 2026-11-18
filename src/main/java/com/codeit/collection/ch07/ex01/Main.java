// 파일 이름: Main.java
package com.codeit.collection.ch07.ex01;

import java.util.function.BinaryOperator;

public class Main {
    public static void main(String[] args) {
        // (num1, num2) -> num1 + num2 는 "두 값을 받아 더한 결과를 돌려준다"는 동작을 적은 람다식입니다.
        // 람다식은 이 한 줄만 따로 쓰면 컴파일되지 않습니다.
        // 인터페이스 타입의 변수에 담거나 메서드의 인자로 넘겨야 하므로,
        // 여기서는 6장에서 쓴 표준 인터페이스 BinaryOperator<Integer>에 담았습니다.
        BinaryOperator<Integer> sum = (num1, num2) -> num1 + num2;

        // 담아 둔 람다식은 인터페이스의 메서드(apply)를 호출해야 실행됩니다.
        System.out.println(sum.apply(1, 2)); // 3
    }
}
