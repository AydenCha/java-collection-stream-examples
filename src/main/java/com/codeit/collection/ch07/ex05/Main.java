// 파일 이름: Main.java
package com.codeit.collection.ch07.ex05;

@FunctionalInterface
interface Calculator {
    int calculate(int a, int b); // 추상 메서드는 이것 하나뿐입니다.

    // 아래 줄의 주석을 풀어 추상 메서드를 하나 더 만들면 컴파일 오류가 납니다.
    // int calculateAgain(int a, int b);
    //   error: Unexpected @FunctionalInterface annotation
    //     Calculator is not a functional interface
    //       multiple non-overriding abstract methods found in interface Calculator
    //   (Calculator에 람다식을 대입한 줄에서도 같은 이유로 오류가 납니다)

    // default 메서드: 인터페이스 안에서 본문까지 작성한 메서드입니다.
    // 추상 메서드가 아니므로 몇 개가 있어도 함수형 인터페이스 규칙에 어긋나지 않습니다.
    // andThenDouble(): 이 계산을 한 뒤 결과를 2배로 만드는 새 Calculator를 람다식으로 만들어 돌려줍니다.
    default Calculator andThenDouble() {
        return (a, b) -> calculate(a, b) * 2;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator plus = (a, b) -> a + b;  // calculate를 더하기로 구현
        Calculator times = (a, b) -> a * b; // calculate를 곱하기로 구현

        System.out.println(plus.calculate(3, 4));                 // 7
        System.out.println(times.calculate(3, 4));                // 12
        System.out.println(plus.andThenDouble().calculate(3, 4)); // 14
    }
}
