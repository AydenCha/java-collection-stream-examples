// 파일 이름: Main.java
package com.codeit.collection.ch05.ex09;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Anna");

        // 바로잡은 코드 1: 파이프라인 끝에 최종 연산(collect)을 붙이고, 결과를 변수에 받습니다.
        List<String> result = names.stream()
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String name) {
                        System.out.println("검사: " + name); // 이제 요소마다 실행됩니다.
                        return name.startsWith("A");
                    }
                })
                .collect(Collectors.toList());
        // 검사: Alice
        // 검사: Bob
        // 검사: Anna
        System.out.println(result); // [Alice, Anna]

        // 바로잡은 코드 2: 스트림이 또 필요하면 stream()을 다시 호출해 새 스트림을 만듭니다.
        System.out.println(names.stream().count()); // 3
        System.out.println(names.stream().count()); // 3
    }
}
