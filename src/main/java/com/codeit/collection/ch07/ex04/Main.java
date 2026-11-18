// 파일 이름: Main.java
// @FunctionalInterface: 추상 메서드가 정확히 하나인지 컴파일러가 검사합니다.
package com.codeit.collection.ch07.ex04;

@FunctionalInterface
interface ExampleFunction {
    int sum(int num1, int num2); // 람다식이 구현할 단 하나의 추상 메서드
}

public class Main {
    public static void main(String[] args) {
        // 람다식 (num1, num2) -> num1 + num2 가 ExampleFunction의 sum(int, int)을 구현합니다.
        // 변수 타입이 ExampleFunction이므로 sum을 호출할 수 있습니다. 2절의 Object 변수와 다른 점입니다.
        ExampleFunction exampleFunction = (num1, num2) -> num1 + num2;

        // 인터페이스의 메서드를 호출하면 람다식의 본문이 실행됩니다.
        System.out.println(exampleFunction.sum(10, 15)); // 25
    }
}
