// 파일 이름: Main.java
package com.codeit.collection.ch06.ex02;

/*
 * ============================================================
 * 2-1. 기존 방식: 익명 클래스(Anonymous Class)
 * ============================================================
 *
 * 클래스를 따로 만들지 않고 "이 자리에서" 구현체를 만듭니다.
 * 하지만 여전히:
 * - 타입 선언
 * - new
 * - 오버라이드
 * - 중괄호 블록
 * 등의 문법이 반복됩니다.
 */
// 추상 메서드가 하나뿐인 인터페이스입니다. 두 정수를 받아 정수 하나를 돌려주는 계산을 뜻합니다.
interface Calculator {
    int sumTwoNumber(int a, int b);
}

public class Main {
    public static void main(String[] args) {
        // new 인터페이스이름() { 구현 }: 이름 없는 구현 클래스를 만들면서 동시에 객체를 생성합니다.
        Calculator c2 = new Calculator() {
            @Override
            public int sumTwoNumber(int a, int b) {
                return a + b;
            }
        };
        System.out.println("20과 30의 합은 : " + c2.sumTwoNumber(20, 30)); // 20과 30의 합은 : 50
    }
}
