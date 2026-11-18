// 파일 이름: Main.java
package com.codeit.collection.ch06.ex11;

/*
 * ============================================================
 * 5. 변수 캡처(Variable Capture) 예시: 정상 케이스
 * ============================================================
 *
 * 람다는 바깥 스코프(여기서는 main)의 "지역 변수"를 참조할 수 있습니다.
 * 단, 그 지역 변수는 final 또는 effectively final이어야 합니다.
 *
 * effectively final:
 * - final 키워드가 없어도
 * - 선언 이후 값이 변경되지 않으면 final처럼 취급
 */
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        String prefix = "결과: "; // 이후 다시 대입하지 않으므로 effectively final입니다.

        Consumer<Integer> printer = score -> {
            // 바깥 지역 변수(prefix)를 캡처해서 사용합니다.
            System.out.println(prefix + score);
        };

        printer.accept(95); // 결과: 95
    }
}
