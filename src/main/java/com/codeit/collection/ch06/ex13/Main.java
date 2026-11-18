// 파일 이름: Main.java
package com.codeit.collection.ch06.ex13;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        int base = 10;
        Function<Integer, Integer> adder = x -> x + base;

        // 바로잡은 코드: base에 다시 대입하는 대신 새 변수를 만들고, 그 변수를 캡처하는 람다를 하나 더 만듭니다.
        // newBase도 이후 다시 대입하지 않으므로 effectively final입니다.
        int newBase = 20;
        Function<Integer, Integer> adder20 = x -> x + newBase;

        System.out.println(adder.apply(5));   // 15
        System.out.println(adder20.apply(5)); // 25
    }
}
