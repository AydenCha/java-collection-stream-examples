// 파일 이름: Main.java
package com.codeit.collection.ch05.ex02;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;   // map에 넘길 인터페이스(4장)

/*
 * 중간 연산 map() (값 변환)
 * - 역할: 각 요소를 다른 값으로 바꿉니다.
 * - Function<T, R>: T를 받아 R을 돌려줍니다. 여기서는 String을 받아 String을 돌려줍니다.
 * - 반환 타입: Stream<R>
 */
public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("kimcoding", "javalee", "hackerna", "luckyguy");

        names.stream() // 스트림 생성
                // Function<입력 타입, 결과 타입>의 apply를 구현합니다.
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String name) {
                        return name.toUpperCase(); // 각 요소를 대문자로 변환
                    }
                })
                .forEach(new Consumer<String>() { // 최종 연산: 출력
                    @Override
                    public void accept(String name) {
                        System.out.println(name);
                    }
                });
        // 출력:
        // KIMCODING
        // JAVALEE
        // HACKERNA
        // LUCKYGUY
    }
}
