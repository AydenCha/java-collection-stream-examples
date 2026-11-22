// 파일 이름: Main.java
package com.codeit.collection.ch04.ex21;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("김코딩", "이자바", "김스프링", "박해커", "kim");

        // 1) 거르고(filter) 바꾸고(map) 출력하기(forEach)
        names.stream()
                .filter(new Predicate<String>() {         // boolean test(T t): 남길지 말지
                    @Override
                    public boolean test(String name) {
                        return name.startsWith("김");
                    }
                })
                .map(new Function<String, String>() {     // R apply(T t): 무엇으로 바꿀지
                    @Override
                    public String apply(String name) {
                        return name + "님";
                    }
                })
                .forEach(new Consumer<String>() {         // void accept(T t): 받아서 무엇을 할지
                    @Override
                    public void accept(String name) {
                        System.out.println("인사 대상: " + name);
                    }
                });
        // 인사 대상: 김코딩님
        // 인사 대상: 김스프링님

        // 2) 익명 클래스 객체는 변수에 담아 두고 여러 스트림에서 다시 쓸 수 있습니다.
        //    Predicate<String> 타입 변수에 Predicate를 구현한 익명 클래스 객체를 담습니다(다형성).
        Predicate<String> isKim = new Predicate<String>() {
            @Override
            public boolean test(String name) {
                return name.startsWith("김");
            }
        };

        // count(): 남은 요소의 개수를 long으로 돌려주는 최종 연산입니다.
        long kimCount = names.stream().filter(isKim).count();
        System.out.println("김씨 수 = " + kimCount); // 김씨 수 = 2
    }
}
