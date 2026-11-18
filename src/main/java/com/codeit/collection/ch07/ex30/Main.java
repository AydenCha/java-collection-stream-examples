// 파일 이름: Main.java
package com.codeit.collection.ch07.ex30;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // 고정값 "A"가 람다식 안에 있으므로, 받은 s를 그대로 넘기는 모양이 아닙니다.
        // 메서드 참조로 바꿀 수 없고, 이 람다식을 그대로 두는 편이 읽기 쉽습니다.
        Predicate<String> startsWithA = s -> s.startsWith("A");

        System.out.println(startsWithA.test("Apple"));  // true
        System.out.println(startsWithA.test("Banana")); // false
    }
}
