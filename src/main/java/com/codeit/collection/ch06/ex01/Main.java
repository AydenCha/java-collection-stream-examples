// 파일 이름: Main.java
package com.codeit.collection.ch06.ex01;

/*
 * ============================================================
 * 2-1. 기존 방식: 구현 클래스 생성
 * ============================================================
 *
 * Java에는 "함수 자체"를 전달하는 문법이 없습니다.
 * 대신 인터페이스의 구현 클래스를 만들고, 그 객체를 전달해 왔습니다.
 * 이 방식은 클래스가 늘어나 작성할 코드가 많습니다.
 */
// 추상 메서드가 하나뿐인 인터페이스입니다. 두 정수를 받아 정수 하나를 돌려주는 계산을 뜻합니다.
interface Calculator {
    int sumTwoNumber(int a, int b);
}

// 더하기 한 줄을 위해 클래스 하나를 따로 만들어야 합니다.
// (보통은 Calculator.java, CalculatorImpl.java, Main.java 세 파일로 나눕니다. 붙여 넣어 바로 실행할 수 있게 한 파일에 모았습니다)
class CalculatorImpl implements Calculator {
    @Override
    public int sumTwoNumber(int a, int b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        // 구현 클래스의 객체를 만들어 인터페이스 타입 변수에 담습니다(다형성).
        Calculator c1 = new CalculatorImpl();
        System.out.println("10과 20의 합은 : " + c1.sumTwoNumber(10, 20)); // 10과 20의 합은 : 30
    }
}
