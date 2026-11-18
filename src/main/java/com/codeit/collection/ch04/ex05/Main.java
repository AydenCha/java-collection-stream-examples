// 파일 이름: Main.java
package com.codeit.collection.ch04.ex05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // ArrayList: 크기가 늘어나는 컬렉션
        List<String> fruitList = new ArrayList<>();
        fruitList.add("바나나 ");
        fruitList.add("사과 ");
        fruitList.add("오렌지 ");

        // 배열: 크기가 고정된 자료구조
        String[] fruitArray = {"바나나 ", "사과 ", "오렌지 "};

        // 스트림을 만드는 방법만 다릅니다.
        Stream<String> listStream = fruitList.stream();         // List는 stream()
        Stream<String> arrayStream = Arrays.stream(fruitArray); // 배열은 Arrays.stream()

        // 요소 하나로 할 일(출력)을 Consumer 익명 클래스 객체 하나로 만들어 두고,
        // 두 스트림에 똑같이 넘깁니다. 만든 뒤의 처리 방법은 데이터 소스와 상관없이 같습니다.
        Consumer<String> printer = new Consumer<String>() {
            @Override
            public void accept(String fruit) {
                System.out.print(fruit);
            }
        };

        listStream.forEach(printer);
        System.out.println(); // 바나나 사과 오렌지
        arrayStream.forEach(printer);
        System.out.println(); // 바나나 사과 오렌지
    }
}
