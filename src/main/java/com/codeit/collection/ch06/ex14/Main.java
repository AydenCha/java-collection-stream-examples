// 파일 이름: Main.java
package com.codeit.collection.ch06.ex14;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> words = List.of("stream", "map", "lambda", "set");

        // 자주 하는 실수: 람다 안에서 바깥 지역 변수의 값을 바꾼다
        // int total = 0;
        // words.forEach(w -> total += w.length()); // 컴파일 오류: total은 effectively final이 아닙니다.

        // 바로잡은 코드: 합계는 스트림의 sum()으로 구합니다(4장의 mapToInt).
        int total = words.stream()
                .mapToInt(w -> w.length()) // 각 단어를 글자 수(int)로 바꿉니다.
                .sum();
        System.out.println("글자 수 합 = " + total); // 글자 수 합 = 18

        // 개수를 셀 때도 바깥 변수에 count++ 하지 않고 count()를 씁니다.
        long shortWords = words.stream()
                .filter(w -> w.length() == 3)
                .count();
        System.out.println("세 글자 단어 수 = " + shortWords); // 세 글자 단어 수 = 2
    }
}
