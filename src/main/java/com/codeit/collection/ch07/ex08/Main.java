// 파일 이름: Main.java
package com.codeit.collection.ch07.ex08;

@FunctionalInterface
interface MyFunctionalInterface {
    void accept(int x); // 매개변수 1개, 리턴값 없음
}

public class Main {
    public static void main(String[] args) {
        MyFunctionalInterface example;

        // 실행문이 여러 줄이므로 중괄호를 씁니다.
        example = (x) -> {
            int result = x * 5;
            System.out.println(result);
        };
        example.accept(2); // 10 (2가 람다식의 x에 대입됩니다)

        // 실행문이 한 줄이므로 중괄호를 생략할 수 있습니다.
        example = (x) -> System.out.println(x * 5);
        example.accept(2); // 10
    }
}
