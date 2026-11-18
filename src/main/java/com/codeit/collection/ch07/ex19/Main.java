// 파일 이름: Main.java
package com.codeit.collection.ch07.ex19;

import java.util.function.BiPredicate;

public class Main {
    public static void main(String[] args) {
        // BiPredicate<String, String>: (String, String) -> boolean
        // String::equals는 (str1, str2) -> str1.equals(str2)와 같습니다.
        // 첫 번째 매개변수 str1이 equals를 호출하는 객체가 되고,
        // 두 번째 매개변수 str2가 equals의 인자로 넘어갑니다.
        BiPredicate<String, String> checker = String::equals;

        System.out.println("비교 결과: " + checker.test("test1", "test2")); // 비교 결과: false
    }
}
