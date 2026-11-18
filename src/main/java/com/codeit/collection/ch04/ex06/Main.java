// 파일 이름: Main.java
package com.codeit.collection.ch04.ex06;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        // 원본 리스트(값을 바꿀 수 있는 ArrayList로 만듭니다)
        List<String> names = new ArrayList<>(List.of("Alice", "Bob", "Charlie"));

        // 요소를 한 줄에 하나씩 출력하는 Consumer 객체
        Consumer<String> printer = new Consumer<String>() {
            @Override
            public void accept(String name) {
                System.out.println(name);
            }
        };

        // map(중간 연산): 요소를 바꾸는 방법을 Function의 apply 메서드로 받습니다.
        // Function<String, String>은 String을 받아 String을 돌려준다는 뜻입니다(8-2에서 자세히 다룹니다).
        names.stream()
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String name) {
                        return name.toUpperCase(); // 대문자로 바꾼 새 문자열을 돌려줍니다.
                    }
                })
                .forEach(printer); // ALICE, BOB, CHARLIE (한 줄에 하나씩)

        // 원본 리스트는 그대로입니다.
        // List에도 forEach 메서드가 있어서 같은 Consumer 객체를 넘길 수 있습니다.
        System.out.println("원본 리스트:");
        names.forEach(printer); // Alice, Bob, Charlie (한 줄에 하나씩)
    }
}
