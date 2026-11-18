// 파일 이름: Main.java
package com.codeit.collection.ch07.ex29;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // Predicate<String>의 추상 메서드는 boolean test(String s) 하나이므로,
        // 익명 클래스에서 타입, 메서드 이름, return을 지우면 람다식 s -> s.startsWith("A")가 남습니다.
        // 실행문이 결과를 돌려주는 식 하나뿐이라 중괄호와 return을 생략했습니다.
        Predicate<String> startsWithA = s -> s.startsWith("A");

        boolean result = startsWithA.test("Apple");
        System.out.println("result = " + result); // result = true
    }
}
