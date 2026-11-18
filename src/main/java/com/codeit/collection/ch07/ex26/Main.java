// 파일 이름: Main.java
package com.codeit.collection.ch07.ex26;

import java.util.function.IntBinaryOperator;

class Calculator {

    // (int, int) -> int
    public int multiply(int x, int y) {
        return x * y;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        // calc 객체로 고정한 채 multiply를 참조합니다. (x, y) -> calc.multiply(x, y)와 같습니다.
        IntBinaryOperator operator = calc::multiply;

        int result = operator.applyAsInt(10, 20);
        System.out.println("인스턴스 메서드 결과: " + result); // 인스턴스 메서드 결과: 200
    }
}
