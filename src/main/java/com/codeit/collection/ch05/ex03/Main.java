// 파일 이름: Main.java
package com.codeit.collection.ch05.ex03;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/*
 * 중간 연산 map() (숫자 가공)
 * - 각 요소에 연산을 적용한 값으로 새 스트림을 만듭니다.
 * - 원본 리스트 numbers는 바뀌지 않습니다(4장에서 본 읽기 전용 특성).
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 6, 9);

        numbers.stream() // 스트림 생성: Stream<Integer>
                // Integer를 받아 Integer를 돌려줍니다.
                // number * 3에서 Integer가 int로 오토언박싱되어 계산되고,
                // 결과 int는 반환할 때 다시 Integer로 오토박싱됩니다(1장).
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer number) {
                        return number * 3;
                    }
                })
                .forEach(new Consumer<Integer>() { // 결과 출력
                    @Override
                    public void accept(Integer number) {
                        System.out.println(number);
                    }
                });
        // 출력:
        // 3
        // 9
        // 18
        // 27

        System.out.println(numbers); // [1, 3, 6, 9] (원본은 그대로입니다)
    }
}
