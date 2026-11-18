// 파일 이름: Main.java
package com.codeit.collection.ch07.ex17;

import java.util.function.UnaryOperator;

class DiscountCalculator {

    // (int) -> int: 가격을 받아 1000원을 뺀 가격을 돌려줍니다.
    public static int applyFixedDiscount(int price) {
        return price - 1000;
    }
}

public class Main {
    public static void main(String[] args) {
        // UnaryOperator<Integer>의 디스크립터는 (Integer) -> Integer입니다.
        // applyFixedDiscount는 int를 받아 int를 돌려주므로 모양이 맞습니다.
        // Integer와 int 사이는 오토박싱, 오토언박싱으로 자동 변환됩니다.
        // 람다식으로 쓰면 price -> DiscountCalculator.applyFixedDiscount(price)
        UnaryOperator<Integer> fix = DiscountCalculator::applyFixedDiscount;

        System.out.println("정적 참조 결과: " + fix.apply(5000)); // 정적 참조 결과: 4000
    }
}
