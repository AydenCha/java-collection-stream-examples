// 파일 이름: Main.java
package com.codeit.collection.ch07.ex07;

@FunctionalInterface
interface MyFunctionalInterface {
    void accept();
}

public class Main {
    public static void main(String[] args) {
        // 실행문이 한 줄이므로 중괄호를 생략할 수 있습니다.
        MyFunctionalInterface example = () -> System.out.println("accept() 호출");

        // accept()를 호출하면 람다식의 본문이 실행됩니다.
        example.accept(); // accept() 호출
    }
}
