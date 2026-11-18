// 파일 이름: Main.java
package com.codeit.collection.ch04.ex16;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Anna");

        names.stream()
                // filter는 Predicate<String>을 받습니다. 요소마다 test를 실행해 true인 요소만 다음 단계로 보냅니다.
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String name) {
                        return name.startsWith("A"); // 이름이 "A"로 시작하는지 검사합니다.
                    }
                })
                // 최종 연산: 남은 요소를 출력합니다.
                .forEach(new Consumer<String>() {
                    @Override
                    public void accept(String name) {
                        System.out.println(name); // Alice, Anna (한 줄에 하나씩)
                    }
                });
    }
}
