// 파일 이름: Main.java
package com.codeit.collection.ch10.ex11;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // 인자 1개: reduce(누적 규칙)
        // 첫 번째 요소를 초기값으로 쓰고 두 번째 요소부터 누적합니다.
        // 스트림이 비어 있으면 결과가 없으므로 OptionalInt를 돌려줍니다.
        OptionalInt reduceOneParam = IntStream.range(1, 4) // 1, 2, 3
                // a=1, b=2 -> 3
                // a=3, b=3 -> 6
                .reduce((a, b) -> a + b);
        System.out.println("reduceOneParam = " + reduceOneParam.getAsInt()); // reduceOneParam = 6

        // 인자 2개: reduce(초기값, 누적 규칙)
        // 초기값이 있어 결과가 항상 존재하므로 int를 그대로 돌려줍니다.
        int reduceTwoParam = IntStream.range(1, 4) // 1, 2, 3
                // 100 + 1 = 101, 101 + 2 = 103, 103 + 3 = 106
                .reduce(100, Integer::sum);
        System.out.println("reduceTwoParam = " + reduceTwoParam); // reduceTwoParam = 106

        // 빈 스트림에 인자 1개 reduce를 쓰면 빈 OptionalInt가 나옵니다.
        // 이때 getAsInt()를 쓰면 NoSuchElementException이 발생하므로 isPresent()나 orElse()로 확인합니다.
        OptionalInt empty = IntStream.range(1, 1).reduce((a, b) -> a + b);
        System.out.println(empty.isPresent()); // false
    }
}
