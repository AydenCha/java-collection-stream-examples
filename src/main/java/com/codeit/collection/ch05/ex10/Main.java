// 파일 이름: Main.java
package com.codeit.collection.ch05.ex10;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/*
 * 지연 평가와 요소 단위 처리 흐름
 * - 요소 하나가 filter -> map -> forEach를 한 번에 통과한 뒤 다음 요소로 넘어갑니다.
 * - 모든 요소의 filter가 끝난 뒤에 map이 실행되는 구조가 아닙니다.
 */
public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "Anna");

        names.stream()
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String name) {
                        System.out.println("filter: " + name);
                        return name.startsWith("A");
                    }
                })
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String name) {
                        System.out.println("map: " + name);
                        return name.toUpperCase();
                    }
                })
                .forEach(new Consumer<String>() {
                    @Override
                    public void accept(String name) {
                        System.out.println("forEach: " + name);
                    }
                });
        // 출력:
        // filter: Alice
        // map: Alice
        // forEach: ALICE
        // filter: Bob
        // filter: Charlie
        // filter: Anna
        // map: Anna
        // forEach: ANNA
        // (Bob, Charlie는 filter에서 false라 map과 forEach까지 가지 않습니다)
    }
}
