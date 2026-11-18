// 파일 이름: Main.java
package com.codeit.collection.ch07.ex28;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // Predicate<String>의 디스크립터는 (String) -> boolean입니다.
        // new Predicate<String>() { ... }: Predicate를 구현한 익명 객체를 만들고,
        // test(String s)를 오버라이딩해 s가 "A"로 시작하는지 검사합니다.
        Predicate<String> startsWithA = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("A");
            }
        };

        boolean result = startsWithA.test("Apple");
        System.out.println("result = " + result); // result = true
    }
}
