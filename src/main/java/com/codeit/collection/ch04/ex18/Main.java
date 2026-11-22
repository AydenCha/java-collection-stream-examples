// 파일 이름: Main.java
package com.codeit.collection.ch04.ex18;

import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Anna");

        // 잘못된 코드: <String>을 빠뜨리면 Predicate의 T가 Object로 처리되어 test(Object)를 구현해야 합니다.
        // long count = names.stream().filter(new Predicate() {
        //     @Override
        //     public boolean test(String name) {   // 컴파일 오류: test(Object)를 구현하지 않았고, 이 메서드는 아무것도 오버라이딩하지 않습니다.
        //         return name.startsWith("A");
        //     }
        // }).count();

        // 바로잡은 코드: new Predicate<String>()처럼 꺾쇠 안에 요소 타입을 적으면 test가 String을 받습니다.
        long count = names.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String name) {
                return name.startsWith("A");
            }
        }).count();
        System.out.println(count); // 2
    }
}
