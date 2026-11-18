// 파일 이름: Main.java
package com.codeit.collection.ch08.ex18;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<String> opt1 = Optional.ofNullable(null);    // 빈 Optional
        Optional<String> opt2 = Optional.ofNullable("123");   // 값이 든 Optional

        // isPresent(): 존재 여부 확인. 값이 있으면 true, 비어 있으면 false를 돌려줍니다.
        if (opt1.isPresent()) {
            System.out.println("opt1: 값이 있습니다.");   // 비어 있으므로 실행되지 않습니다.
        }
        if (opt2.isPresent()) {
            System.out.println("opt2: 값이 있습니다.");   // opt2: 값이 있습니다.
        }

        /*
         * ifPresent(Consumer): 값이 있을 때만 넘긴 람다를 실행합니다.
         * - 람다의 매개변수 v에는 Optional 안의 값이 들어옵니다.
         * - 비어 있으면 아무 일도 하지 않습니다. if 문과 get()을 따로 쓰지 않아도 됩니다.
         */
        opt1.ifPresent(v -> System.out.println("opt1 값: " + v)); // 출력 없음
        opt2.ifPresent(v -> System.out.println("opt2 값: " + v)); // opt2 값: 123
    }
}
