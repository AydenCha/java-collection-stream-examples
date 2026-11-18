// 파일 이름: Main.java
package com.codeit.collection.ch03.ex07;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // 1) 개수 세기: getOrDefault + put
        String[] visits = {"home", "login", "home", "mypage", "home", "login"};

        Map<String, Integer> count = new HashMap<>();
        for (String page : visits) {
            // getOrDefault(key, 0): 키가 있으면 그 값을, 없으면 0을 돌려줍니다.
            // 처음 나온 페이지는 0 + 1 = 1을 넣고, 이미 있으면 기존 값에 1을 더해 다시 넣습니다.
            count.put(page, count.getOrDefault(page, 0) + 1);
        }
        System.out.println(count.get("home"));   // 3
        System.out.println(count.get("login"));  // 2
        System.out.println(count.get("mypage")); // 1

        // 없는 키: get은 null, getOrDefault는 지정한 기본값
        System.out.println(count.get("cart"));              // null
        System.out.println(count.getOrDefault("cart", 0));  // 0

        // 2) 없을 때만 넣기: putIfAbsent
        Map<String, Integer> scores = new HashMap<>();
        scores.put("민지", 85);
        scores.putIfAbsent("민지", 0);   // 이미 있는 키이므로 아무것도 바꾸지 않습니다.
        scores.putIfAbsent("은우", 65);  // 없는 키이므로 새로 넣습니다.
        System.out.println(scores.get("민지")); // 85
        System.out.println(scores.get("은우")); // 65
    }
}
