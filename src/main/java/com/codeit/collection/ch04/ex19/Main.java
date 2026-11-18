// 파일 이름: Main.java
package com.codeit.collection.ch04.ex19;

import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Anna");

        // forEach는 Consumer<String>을 받습니다. 요소마다 accept를 실행하고, 돌려받는 값은 없습니다(void).
        names.stream()
                .forEach(new Consumer<String>() {
                    @Override
                    public void accept(String name) {
                        System.out.println("이름: " + name); // 이름: Alice, 이름: Bob, 이름: Anna (한 줄에 하나씩)
                    }
                });
    }
}
