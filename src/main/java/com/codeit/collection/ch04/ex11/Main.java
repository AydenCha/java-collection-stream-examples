// 파일 이름: Main.java
package com.codeit.collection.ch04.ex11;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        // int 배열을 넘기면 int 전용 스트림인 IntStream이 만들어집니다.
        // 요소를 Integer로 감싸지 않으므로 오토박싱이 일어나지 않습니다.
        IntStream stream = Arrays.stream(numbers);

        // sum(): IntStream에 있는 숫자 전용 최종 연산
        System.out.println("sum = " + stream.sum()); // sum = 15

        // 스트림은 한 번만 쓸 수 있으므로 평균은 스트림을 새로 만들어 구합니다.
        // average()는 요소가 하나도 없을 때를 대비해 결과를 OptionalDouble이라는 객체에 담아 돌려주고,
        // getAsDouble()로 그 안의 double 값을 꺼냅니다(Optional은 8장에서 배웁니다).
        System.out.println("average = " + Arrays.stream(numbers).average().getAsDouble()); // average = 3.0
    }
}
