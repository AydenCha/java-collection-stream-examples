// 파일 이름: Main.java
package com.codeit.collection.ch08.ex23;

import java.util.Optional;

public class Main {
    static String createDefault() {
        System.out.println("기본값을 만듭니다");
        return "guest";
    }

    public static void main(String[] args) {
        Optional<String> name = Optional.of("kimcoding");

        /*
         * 바로잡은 코드: orElseGet에는 기본값 대신 "기본값을 만드는 방법"(Supplier 람다)을 넘깁니다.
         * 람다는 Optional이 비어 있을 때만 실행됩니다. (Supplier는 7장에서 배운 함수형 인터페이스입니다)
         */
        String result = name.orElseGet(() -> createDefault());
        System.out.println(result); // kimcoding (createDefault()는 실행되지 않습니다)

        Optional<String> empty = Optional.empty();
        String other = empty.orElseGet(() -> createDefault());
        System.out.println(other);
        // 기본값을 만듭니다   <- 비어 있을 때만 실행됩니다.
        // guest
    }
}
