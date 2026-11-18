// 파일 이름: Main.java
package com.codeit.collection.ch08.ex24;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Ruby", "Python", "Java", "Go", "Kotlin");
        Optional<List<String>> listOptional = Optional.of(languages);

        int size = listOptional
                /*
                 * [변환] map(Function)
                 * - 상자 안의 리스트를 꺼내서 .size()를 측정하고 다시 Optional 상자에 담습니다.
                 * - Optional이 비어 있다면(Optional.ofNullable(null)로 만든 경우) .size()는 실행되지 않고 넘어갑니다. Optional.of(null)은 여기까지 오기 전에 NullPointerException이 납니다.
                 */
                .map(List::size) 
                // 최종적으로 값이 비어 있다면 0을 반환합니다.
                .orElse(0);
        System.out.println(size);  // 출력: 5
    }
}
