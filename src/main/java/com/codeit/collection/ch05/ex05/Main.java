// 파일 이름: Main.java
package com.codeit.collection.ch05.ex05;

import java.util.List;
import java.util.function.Consumer;

/*
 * 최종 연산 forEach()
 * - 역할: 스트림의 각 요소를 받아 소비합니다(Consumer).
 * - 반환값: 없음(void)
 * - 특징:
 *   1. 호출되는 순간 스트림이 소모됩니다.
 *   2. 그 뒤로 이 스트림은 다시 쓸 수 없습니다(4장의 일회용 특성).
 *   3. 앞에 중간 연산이 있었다면 이 시점에 실제로 실행됩니다(지연 평가).
 */
public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Anna");

        names.stream() // 스트림 생성
                // 최종 연산: Consumer<String>의 accept가 요소마다 한 번씩 실행됩니다.
                .forEach(new Consumer<String>() {
                    @Override
                    public void accept(String name) {
                        System.out.println("이름: " + name);
                    }
                });
    }
}
