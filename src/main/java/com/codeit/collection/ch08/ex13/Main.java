// 파일 이름: Main.java
package com.codeit.collection.ch08.ex13;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {2, 4, 6};

        // [최종 연산] allMatch: "모든 요소가 조건을 만족하는가?" (AND 연산과 유사)
        System.out.println(Arrays.stream(nums).allMatch(n -> n % 2 == 0)); // true (모두 짝수이므로)

        // [최종 연산] anyMatch: "최소한 하나 이상의 요소가 조건을 만족하는가?" (OR 연산과 유사)
        System.out.println(Arrays.stream(nums).anyMatch(n -> n % 3 == 0)); // true (3의 배수인 6이 존재하므로)

        // [최종 연산] noneMatch: "모든 요소가 조건을 만족하지 않는가?"
        System.out.println(Arrays.stream(nums).noneMatch(n -> n < 0));     // true (음수가 하나도 없으므로)
    }
}
