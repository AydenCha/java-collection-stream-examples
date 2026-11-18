// 파일 이름: Main.java
package com.codeit.collection.ch04.ex12;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("자바", "파이썬", "고");

        // stream()은 Collection 인터페이스에 정의되어 있어서, List와 Set 구현 클래스는 모두 같은 방법으로 스트림을 만듭니다.
        Stream<String> stream = names.stream();

        stream.forEach(new Consumer<String>() {
            @Override
            public void accept(String name) {
                System.out.println(name); // 자바, 파이썬, 고 (한 줄에 하나씩)
            }
        });
    }
}
