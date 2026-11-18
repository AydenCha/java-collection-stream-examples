// 파일 이름: Main.java
package com.codeit.collection.ch04.ex04;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class Main {
    public static void main(String[] args) {
        // List에 있는 숫자 중에서 4보다 큰 짝수의 합계 구하기
        List<Integer> numbers = List.of(1, 3, 6, 7, 8, 11);

        // 생성, 중간 연산, 최종 연산을 이어 붙여 "무엇을" 할지만 적습니다.
        // 각 연산이 요소를 어떻게 처리할지는 인터페이스를 구현한 익명 클래스 객체로 넘깁니다.
        int sum = numbers.stream()                       // [1] 생성: Stream<Integer>
                .filter(new Predicate<Integer>() {       // [2] 중간 연산: test가 true인 요소만 남깁니다.
                    @Override
                    public boolean test(Integer number) {
                        return number > 4 && number % 2 == 0;
                    }
                })
                .mapToInt(new ToIntFunction<Integer>() { // [2] 중간 연산: Integer를 int로 바꿔 IntStream을 만듭니다.
                    @Override
                    public int applyAsInt(Integer number) {
                        return number;                   // 오토언박싱: Integer가 int로 바뀝니다.
                    }
                })
                .sum();                                  // [3] 최종 연산: 남은 값을 모두 더합니다.

        System.out.println("선언형 프로그래밍을 사용한 합계 : " + sum); // 선언형 프로그래밍을 사용한 합계 : 14
    }
}
