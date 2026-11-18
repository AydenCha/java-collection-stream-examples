// 파일 이름: Main.java
package com.codeit.collection.ch03.ex12;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        /*
         * ============================================================
         * 4-2-1. List -> Set (중복 제거)
         * ============================================================
         *
         * List에 중복 데이터가 있을 때
         * Set으로 변환하면 자동으로 중복이 제거됩니다.
         */

        List<String> rawList = List.of("A", "B", "A", "C");

        // HashSet 생성자에 List를 넘기면 List의 요소를 모두 담은 Set이 만들어집니다.
        Set<String> uniqueSet = new HashSet<>(rawList);

        System.out.println(uniqueSet);        // [A, B, C] (HashSet이라 순서는 보장되지 않습니다)
        System.out.println(uniqueSet.size()); // 3
    }
}
