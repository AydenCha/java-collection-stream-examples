// 파일 이름: Main.java
package com.codeit.collection.ch04.ex09;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String[] arr = {"김코딩", "이자바", "박해커"};

        // Arrays.stream(배열): 배열을 데이터 소스로 하는 스트림을 만듭니다.
        Stream<String> stream = Arrays.stream(arr);

        // 최종 연산 forEach: 요소를 하나씩 Consumer의 accept에 넘깁니다.
        stream.forEach(new Consumer<String>() {
            @Override
            public void accept(String name) {
                System.out.println(name); // 김코딩, 이자바, 박해커 (한 줄에 하나씩)
            }
        });
    }
}
