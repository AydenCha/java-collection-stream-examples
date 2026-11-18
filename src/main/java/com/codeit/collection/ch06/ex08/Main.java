// 파일 이름: Main.java
package com.codeit.collection.ch06.ex08;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        // Function<String, String>: String을 받아 String을 돌려주는 인터페이스입니다(4장). apply(값)으로 실행합니다.

        // 실행문이 두 줄이라 중괄호와 return을 생략할 수 없습니다.
        Function<String, String> greet = name -> {
            String result = "안녕하세요, " + name + "님";
            return result;
        };

        System.out.println(greet.apply("김코딩")); // 안녕하세요, 김코딩님
    }
}
