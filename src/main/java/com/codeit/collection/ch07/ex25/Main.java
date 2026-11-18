// 파일 이름: Main.java
package com.codeit.collection.ch07.ex25;

import java.util.function.IntBinaryOperator;

class Calculator {

    // (int, int) -> int
    public static int add(int x, int y) {
        return x + y;
    }
}

public class Main {
    public static void main(String[] args) {
        // IntBinaryOperator: (int, int) -> int, 추상 메서드는 applyAsInt입니다.
        // Calculator.add(int, int)와 모양이 같으므로 정적 메서드 참조로 연결할 수 있습니다.
        IntBinaryOperator operator = Calculator::add;

        int result = operator.applyAsInt(10, 20);
        System.out.println("정적 메서드 결과: " + result); // 정적 메서드 결과: 30
    }
}
