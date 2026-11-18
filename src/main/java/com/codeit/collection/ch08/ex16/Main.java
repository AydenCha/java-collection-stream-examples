// 파일 이름: Main.java
package com.codeit.collection.ch08.ex16;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // Optional.of(value): 절대 null이 아님이 확실할 때 사용. null을 넣으면 바로 NullPointerException이 발생합니다.
        Optional<String> opt0 = Optional.of("abc");
        // Optional<String> bad = Optional.of(null); // NullPointerException

        // Optional.ofNullable(value): null일 수도 있을 때 사용합니다. 위 줄을 바로잡은 방법입니다.
        Optional<String> opt1 = Optional.ofNullable(null);     // null이어도 에러 없이 빈 객체 반환
        Optional<String> opt2 = Optional.ofNullable("123");   // 값이 있으면 감싸서 반환

        // Optional을 그대로 출력하면 안에 든 값이 보입니다.
        System.out.println(opt0); // Optional[abc]
        System.out.println(opt1); // Optional.empty
        System.out.println(opt2); // Optional[123]
    }
}
