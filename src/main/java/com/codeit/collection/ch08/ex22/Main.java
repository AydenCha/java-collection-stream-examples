// 파일 이름: Main.java
package com.codeit.collection.ch08.ex22;

import java.util.Optional;

public class Main {
    // 기본값을 만드는 메서드입니다. 실행되었는지 보이도록 한 줄을 출력합니다.
    static String createDefault() {
        System.out.println("기본값을 만듭니다");
        return "guest";
    }

    public static void main(String[] args) {
        Optional<String> name = Optional.of("kimcoding");

        // 자주 하는 실수: orElse의 괄호 안은 Optional에 값이 있어도 먼저 계산됩니다.
        String result = name.orElse(createDefault());
        System.out.println(result);
        // 기본값을 만듭니다   <- 값이 있는데도 createDefault()가 실행되었습니다.
        // kimcoding
    }
}
