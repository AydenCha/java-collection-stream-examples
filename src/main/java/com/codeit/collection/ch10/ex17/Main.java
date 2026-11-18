// 파일 이름: Main.java
package com.codeit.collection.ch10.ex17;

import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // summarizingLong: long 값을 요약합니다. Long::longValue는 Long 객체에서 long 값을 꺼내는 메서드 참조입니다.
        LongSummaryStatistics lStats = List.of(100L, 200L, 300L).stream()
                .collect(Collectors.summarizingLong(Long::longValue));

        System.out.println("합계: " + lStats.getSum()); // 합계: 600
    }
}
