// 파일 이름: Main.java
package com.codeit.collection.ch10.ex19;

import java.util.Arrays;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5};

        OptionalDouble avgOptional = Arrays.stream(intArray).average();
        // getAsDouble()은 값이 있을 때만 쓸 수 있습니다. 비어 있으면 NoSuchElementException이 발생합니다.
        double result = avgOptional.getAsDouble();
        System.out.println("전체 요소의 평균값: " + result); // 전체 요소의 평균값: 3.0

        // 빈 배열의 평균은 빈 OptionalDouble입니다. orElse로 기본값을 주면 예외 없이 처리됩니다.
        int[] empty = {};
        System.out.println(Arrays.stream(empty).average().orElse(0.0)); // 0.0
    }
}
