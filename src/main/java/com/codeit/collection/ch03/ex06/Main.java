// 파일 이름: Main.java
package com.codeit.collection.ch03.ex06;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] visits = {"home", "login", "home"};
        Map<String, Integer> count = new HashMap<>();

        try {
            for (String page : visits) {
                // 잘못된 코드: 처음 나온 페이지는 get 결과가 null입니다.
                // null을 int로 바꿔(오토언박싱) 1을 더하려다 NullPointerException이 발생합니다.
                count.put(page, count.get(page) + 1);
            }
        } catch (NullPointerException e) {
            System.out.println("NullPointerException 발생"); // NullPointerException 발생
        }
    }
}
