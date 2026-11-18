// 파일 이름: Main.java
package com.codeit.collection.ch07.ex16;

import java.util.function.BinaryOperator;

public class Main {
    public static void main(String[] args) {
        // 람다식: 받은 left, right를 그대로 Math.max에 넘기기만 합니다.
        BinaryOperator<Integer> maxByLambda = (left, right) -> Math.max(left, right);

        // 메서드 참조: 클래스이름::메서드이름. 괄호와 매개변수를 적지 않습니다.
        // 매개변수를 어디로 넘길지는 BinaryOperator<Integer>의 모양((Integer, Integer) -> Integer)을 보고 컴파일러가 정합니다.
        BinaryOperator<Integer> maxByRef = Math::max;

        System.out.println(maxByLambda.apply(3, 7)); // 7
        System.out.println(maxByRef.apply(3, 7));    // 7
    }
}
