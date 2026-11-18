// 파일 이름: Main.java
package com.codeit.collection.ch06.ex12;

/*
 * ============================================================
 * 5. 변수 캡처 예시: 컴파일 오류 케이스
 * ============================================================
 *
 * 람다에서 참조한 지역 변수는 다시 대입할 수 없습니다.
 * (final / effectively final 규칙 위반)
 */
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        int base = 10;

        // base를 캡처(참조)합니다.
        Function<Integer, Integer> adder = x -> x + base;

        // 캡처한 지역 변수를 다시 대입하면 컴파일 오류가 납니다.
        // 아래 줄의 주석을 풀면 위의 람다 줄에서 다음 오류가 납니다.
        //   error: local variables referenced from a lambda expression must be final or effectively final
        // base = 20;

        System.out.println(adder.apply(5)); // 15
    }
}
