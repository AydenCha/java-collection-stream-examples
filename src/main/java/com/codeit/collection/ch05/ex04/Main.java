// 파일 이름: Main.java
package com.codeit.collection.ch05.ex04;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/*
 * 중간 연산 파이프라인
 * 1. 스트림 생성
 * 2. filter()로 조건에 맞는 요소만 남기기
 * 3. map()으로 값 변환
 * 4. 최종 연산 forEach()
 * 중간 연산은 항상 Stream을 반환하므로 점(.)으로 계속 이어 붙일 수 있습니다(체이닝).
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 6, 7, 8, 11);

        numbers.stream()
                .filter(new Predicate<Integer>() {      // 4보다 큰 수만
                    @Override
                    public boolean test(Integer n) {
                        return n > 4;
                    }
                })
                .map(new Function<Integer, Integer>() { // 각 값에 2를 곱함
                    @Override
                    public Integer apply(Integer n) {
                        return n * 2;
                    }
                })
                .forEach(new Consumer<Integer>() {      // 최종 연산
                    @Override
                    public void accept(Integer n) {
                        System.out.println(n);
                    }
                });
        // 출력:
        // 12
        // 14
        // 16
        // 22
    }
}
