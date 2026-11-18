// 파일 이름: Main.java
package com.codeit.collection.ch07.ex32;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // 1. 권장하는 형태: 람다식. 조건 "A"가 코드에 그대로 보입니다.
        Predicate<String> startsWithA = s -> s.startsWith("A");
        System.out.println("람다 결과: " + startsWithA.test("Apple")); // 람다 결과: true

        // 2. 아래 줄은 컴파일 오류입니다.
        //    Predicate<String>은 (String) -> boolean인데,
        //    String::startsWith는 (String, String) -> boolean 모양이라 매개변수 개수가 맞지 않습니다.
        // Predicate<String> err = String::startsWith;

        // 3. 구조를 바꾸면 가능합니다. BiPredicate<String, String>은 (String, String) -> boolean입니다.
        //    첫 번째 인자는 startsWith를 호출하는 객체, 두 번째 인자는 접두어입니다.
        BiPredicate<String, String> biChecker = String::startsWith;
        System.out.println("BiPredicate 결과: " + biChecker.test("Apple", "A")); // BiPredicate 결과: true
    }
}
