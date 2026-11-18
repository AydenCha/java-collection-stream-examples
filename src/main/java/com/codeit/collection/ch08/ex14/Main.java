// 파일 이름: Main.java
package com.codeit.collection.ch08.ex14;

import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // [최종 연산] findFirst(): 스트림 내의 '첫 번째' 요소를 찾아 반환 (순서가 중요할 때)
        Optional<String> first = Stream.of("a", "b", "c").findFirst();

        // [최종 연산] findAny(): 스트림 내의 요소 중 '아무거나 하나'를 반환
        Optional<String> any = Stream.of("a", "b", "c").findAny();

        /*
         * Optional 활용 예시:
         * - Optional은 값이 들어 있을 수도, 비어 있을 수도 있는 상자입니다(3절에서 자세히 봅니다).
         * - .orElse("기본값"): 값이 있으면 그 값을, 비어 있다면 "기본값"을 대신 꺼냅니다.
         */
        System.out.println(first.orElse("데이터 없음")); // a
        System.out.println(any.orElse("데이터 없음"));   // a (순차 스트림에서는 보통 첫 요소가 나오지만 보장되지는 않습니다)

        // filter를 통과한 요소가 하나도 없으면 빈 Optional이 돌아오고, orElse의 기본값이 쓰입니다.
        Optional<String> none = Stream.of("a", "b", "c")
            .filter(s -> s.startsWith("z"))
            .findFirst();
        System.out.println(none.orElse("데이터 없음")); // 데이터 없음
    }
}
