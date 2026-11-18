// 파일 이름: Main.java
package com.codeit.collection.ch06.ex06;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        // Consumer<String>: String 하나를 받아 사용하고 돌려주는 값은 없는 인터페이스입니다. accept(값)으로 실행합니다.

        // 매개변수가 1개일 때 타입과 소괄호를 모두 쓴 형태
        Consumer<String> a = (String name) -> System.out.println(name);

        // 매개변수 타입은 생략할 수 있습니다(Consumer<String>을 보고 컴파일러가 String으로 알아냅니다).
        Consumer<String> b = (name) -> System.out.println(name);

        // 매개변수가 1개이면 타입과 소괄호를 함께 생략할 수 있습니다.
        Consumer<String> c = name -> System.out.println(name);

        a.accept("타입과 괄호를 모두 쓴 형태");     // 타입과 괄호를 모두 쓴 형태
        b.accept("타입을 생략한 형태");             // 타입을 생략한 형태
        c.accept("타입과 괄호를 생략한 형태");      // 타입과 괄호를 생략한 형태
    }
}
