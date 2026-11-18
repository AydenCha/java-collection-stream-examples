// 파일 이름: Main.java
package com.codeit.collection.ch06.ex03;

/*
 * ============================================================
 * 2-2. 람다 방식
 * ============================================================
 *
 * 람다는 "추상 메서드가 하나뿐인 인터페이스"의 구현체를 더 짧게 쓰는 문법입니다.
 * 즉, Java에서 람다는 진짜 함수라기보다
 * 그 인터페이스의 메서드 하나를 구현하는 표현식입니다.
 *
 * (x, y) -> x + y 는
 * sumTwoNumber(x, y)를 구현한 것으로 해석됩니다.
 */
// 추상 메서드가 하나뿐인 인터페이스입니다. 두 정수를 받아 정수 하나를 돌려주는 계산을 뜻합니다.
interface Calculator {
    int sumTwoNumber(int a, int b);
}

public class Main {
    public static void main(String[] args) {
        // 익명 클래스에서 new Calculator(), @Override, 메서드 이름, 타입, return을 모두 걷어낸 모양입니다.
        // 매개변수 타입(int)은 Calculator의 sumTwoNumber 선언을 보고 컴파일러가 알아냅니다.
        Calculator c3 = (x, y) -> x + y;
        System.out.println("40과 50의 합은 : " + c3.sumTwoNumber(40, 50)); // 40과 50의 합은 : 90
    }
}
