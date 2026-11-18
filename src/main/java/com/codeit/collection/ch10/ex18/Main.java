// 파일 이름: Main.java
package com.codeit.collection.ch10.ex18;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5};

        // 1. count(): 요소의 개수 (long 반환)
        long count = Arrays.stream(intArray).count();

        // 2. sum(): 요소의 합계 (int 반환)
        int sum = Arrays.stream(intArray).sum();

        // 3. average(): 평균 (OptionalDouble 반환). getAsDouble()로 double 값을 꺼냅니다.
        double average = Arrays.stream(intArray).average().getAsDouble();

        // 4. max(), min(): 최댓값, 최솟값 (OptionalInt 반환). getAsInt()로 int 값을 꺼냅니다.
        int max = Arrays.stream(intArray).max().getAsInt();
        int min = Arrays.stream(intArray).min().getAsInt();

        // 5. findFirst(): 첫 번째 요소 (OptionalInt 반환)
        int first = Arrays.stream(intArray).findFirst().getAsInt();

        System.out.println("count = " + count);     // count = 5
        System.out.println("sum = " + sum);         // sum = 15
        System.out.println("average = " + average); // average = 3.0
        System.out.println("max = " + max);         // max = 5
        System.out.println("min = " + min);         // min = 1
        System.out.println("first = " + first);     // first = 1
    }
}
