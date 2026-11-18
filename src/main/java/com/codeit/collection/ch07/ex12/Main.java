// 파일 이름: Main.java
package com.codeit.collection.ch07.ex12;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        // Function<String, Integer>: (String) -> Integer
        // 문자열을 받아 다른 타입(글자 수)으로 바꿉니다.
        Function<String, Integer> strToInt = s -> s.length();

        // apply(T t)를 호출하면 람다식이 실행되고 결과를 돌려받습니다.
        System.out.println("글자 수: " + strToInt.apply("Hello Java")); // 글자 수: 10

        // BiFunction<String, String, String>: (String, String) -> String
        // 두 개를 받아 하나로 만듭니다.
        BiFunction<String, String, String> fullPath = (dir, file) -> dir + "/" + file;

        System.out.println(fullPath.apply("/users/home", "test.txt")); // /users/home/test.txt
    }
}
