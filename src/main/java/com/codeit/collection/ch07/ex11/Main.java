// 파일 이름: Main.java
package com.codeit.collection.ch07.ex11;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        // Supplier<Integer>: () -> Integer
        // 받는 값 없이, get()을 호출할 때마다 값을 만들어 돌려줍니다.
        // Math.random()은 0 이상 1 미만의 실수를 무작위로 돌려줍니다.
        // 100을 곱한 뒤 (int)로 바꾸면 0부터 99 사이의 정수가 됩니다.
        Supplier<Integer> randomNum = () -> (int) (Math.random() * 100);

        System.out.println("랜덤 번호: " + randomNum.get()); // 실행할 때마다 0부터 99 사이의 다른 값

        // BooleanSupplier: () -> boolean
        // 기본형 boolean을 돌려주는 전용 인터페이스이고, 추상 메서드 이름은 getAsBoolean입니다.
        BooleanSupplier isServerUp = () -> true; // 서버 상태 확인을 흉내 낸 코드

        System.out.println("서버 동작 여부: " + isServerUp.getAsBoolean()); // 서버 동작 여부: true
    }
}
