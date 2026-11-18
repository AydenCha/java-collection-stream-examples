// 파일 이름: Main.java
package com.codeit.collection.ch09.ex04;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<List<String>> rawData = List.of(
            List.of("Java", "Python", "Java"),
            List.of("Kotlin", "JavaScript"),
            List.of("Python", "Rust", "Go")
        );

        // 자주 하는 실수 1: flatMap 대신 map에 List::stream을 넘긴다
        // map은 요소 하나를 값 하나로 바꾸기만 하므로, 안쪽 리스트가 스트림 객체 3개로 바뀔 뿐 펼쳐지지 않습니다.
        List<Stream<String>> wrong = rawData.stream()
            .map(List::stream)                       // Stream<Stream<String>>
            .collect(Collectors.toList());
        System.out.println(wrong.size());            // 3 (펼쳐진 기술 8개 대신 스트림 3개가 담깁니다)
        System.out.println(wrong.get(0));            // java.util.stream.ReferencePipeline$Head@... (@ 뒤 값은 실행마다 다릅니다)

        // 자주 하는 실수 2: 숫자 스트림에 joining을 쓴다
        List<Integer> scores = List.of(90, 85, 70);
        // String line = scores.stream().collect(Collectors.joining(", ")); // 컴파일 오류: joining은 문자열 스트림에만 쓸 수 있습니다
        System.out.println(scores.size());           // 3
    }
}
