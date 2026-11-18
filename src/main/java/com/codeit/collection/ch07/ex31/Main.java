// 파일 이름: Main.java
package com.codeit.collection.ch07.ex31;

import java.util.function.BiPredicate;

public class Main {
    public static void main(String[] args) {
        // BiPredicate<String, String>: String 두 개를 받아 boolean을 돌려줍니다.
        // String::startsWith는 (s, prefix) -> s.startsWith(prefix)와 같습니다.
        // 첫 번째 인자가 startsWith를 호출하는 객체, 두 번째 인자가 접두어입니다.
        BiPredicate<String, String> startsWith = String::startsWith;

        System.out.println(startsWith.test("Apple", "A")); // true
    }
}
