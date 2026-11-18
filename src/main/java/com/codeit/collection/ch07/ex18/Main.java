// 파일 이름: Main.java
package com.codeit.collection.ch07.ex18;

import java.util.function.UnaryOperator;

class DiscountCalculator {

    // (int) -> int: VIP 고객에게 10% 할인한 가격을 돌려줍니다.
    public int applyVipDiscount(int price) {
        return (int) (price * 0.9);
    }
}

public class Main {
    public static void main(String[] args) {
        DiscountCalculator calc = new DiscountCalculator();

        // calc라는 특정 객체의 applyVipDiscount를 참조합니다.
        // 메서드를 호출할 객체가 calc로 이미 정해져 있으므로, apply에 넘긴 값은 applyVipDiscount의 매개변수로 들어갑니다.
        // 람다식으로 쓰면 price -> calc.applyVipDiscount(price)
        UnaryOperator<Integer> vip = calc::applyVipDiscount;

        System.out.println("인스턴스 참조 결과: " + vip.apply(5000)); // 인스턴스 참조 결과: 4500
    }
}
