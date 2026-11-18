// 파일 이름: Main.java
package com.codeit.collection.ch05.ex07;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/*
 * 스트림의 지연 평가(Lazy Evaluation)
 * - 중간 연산(filter, map 등)은 정의한 순간에 실행되지 않습니다.
 * - 최종 연산이 호출되는 순간에 실제로 실행됩니다.
 * - 덕분에 필요 없는 연산을 줄일 수 있습니다.
 */
public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "Anna");

        // 중간 연산만 정의합니다. filter의 결과도 스트림이므로 Stream<String> 변수에 담을 수 있습니다.
        // 아직 최종 연산이 없어서 test는 한 번도 실행되지 않습니다.
        Stream<String> stream = names.stream()
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String name) {
                        System.out.println("Filtering: " + name); // 언제 실행되는지 보려고 출력합니다.
                        return name.startsWith("A");
                    }
                });

        // 이 시점까지는 "Filtering: ..."이 하나도 출력되지 않습니다.
        System.out.println("최종 연산 시작");

        // 최종 연산 호출: 여기서부터 filter가 요소마다 실제로 실행됩니다.
        stream.forEach(new Consumer<String>() {
            @Override
            public void accept(String name) {
                System.out.println(name);
            }
        });
    }
}
