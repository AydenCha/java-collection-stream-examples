// 파일 이름: Main.java
package com.codeit.collection.ch09.ex03;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // 데이터 준비: 중첩 리스트(List 안에 List가 있음)
        List<List<String>> rawData = List.of(
            List.of("Java", "Python", "Java"),
            List.of("Kotlin", "JavaScript"),
            List.of("Python", "Rust", "Go")
        );

        // [1단계] 펼치기 -> 중복 제거 -> 정렬 -> 수집
        List<String> techList = rawData.stream()   // Stream<List<String>>: 요소가 안쪽 리스트 3개
            .flatMap(Collection::stream)            // 안쪽 리스트를 스트림으로 바꿔 한 줄로 펼침 -> Stream<String> 8개
            .distinct()                             // 중복된 "Java", "Python" 제거 -> 6개
            .sorted()                               // String의 기본 순서(사전순)로 정렬
            .collect(Collectors.toList());          // List<String>으로 수집

        // [2단계] 수집한 리스트를 다시 스트림으로 열어 문자열로 포맷팅
        // joining(구분자, 앞에 붙일 문자, 뒤에 붙일 문자)
        String formatted = techList.stream()
            .collect(Collectors.joining(", ", "[", "]"));

        System.out.println("결과 리스트: " + techList);   // 결과 리스트: [Go, Java, JavaScript, Kotlin, Python, Rust]
        System.out.println("포맷팅 결과: " + formatted);  // 포맷팅 결과: [Go, Java, JavaScript, Kotlin, Python, Rust]

        // [3단계] 1단계와 2단계를 collect 한 번으로 합치기
        // collectingAndThen은 수집(collect)이 끝난 직후에 그 결과로 추가 작업을 할 때 씁니다.
        String oneShot = rawData.stream()
            .flatMap(List::stream)                  // Collection::stream과 같은 뜻입니다(List도 Collection입니다)
            .distinct()
            .sorted()
            .collect(Collectors.collectingAndThen(
                Collectors.toList(),                // (1) 먼저 리스트로 모읍니다
                list -> list.stream()               // (2) 그 리스트를 다시 스트림으로 열어서
                    .collect(Collectors.joining(", ", "[", "]")) // (3) 문자열로 합칩니다
            ));

        System.out.println("하나로 합친 결과: " + oneShot); // 하나로 합친 결과: [Go, Java, JavaScript, Kotlin, Python, Rust]

        // 참고: Go가 맨 앞, Java가 JavaScript 앞에 오는 이유
        // 문자열은 앞 글자부터 비교하고, 앞부분이 모두 같으면 짧은 쪽이 앞에 옵니다.
        System.out.println("Java".compareTo("JavaScript") < 0); // true
    }
}
