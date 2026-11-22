// 파일 이름: Main.java
package com.codeit.collection.ch07.ex24;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] visits = {"home", "login", "home", "mypage", "home", "login"};

        // 개수 세기: 3장에서 쓴 getOrDefault + put
        Map<String, Integer> before = new HashMap<>();
        for (String page : visits) {
            before.put(page, before.getOrDefault(page, 0) + 1);
        }

        // 개수 세기: merge(키, 값, 합치는 함수)
        // 키가 없으면 1을 그대로 넣고, 있으면 기존 값과 1을 Integer.sum으로 더한 값으로 바꿉니다.
        // 합치는 함수의 모양은 (Integer, Integer) -> Integer이고, Integer::sum은 정적 메서드 참조입니다.
        Map<String, Integer> count = new HashMap<>();
        for (String page : visits) {
            count.merge(page, 1, Integer::sum);
        }
        System.out.println(before.get("home") + " " + count.get("home")); // 3 3

        // 첫 글자별로 묶기: containsKey + put
        Map<String, List<String>> groupBefore = new HashMap<>();
        for (String page : visits) {
            // substring(0, 1): 0번 인덱스부터 1번 인덱스 앞까지 잘라 낸 문자열, 즉 첫 글자를 돌려줍니다.
            String initial = page.substring(0, 1);
            if (!groupBefore.containsKey(initial)) {
                groupBefore.put(initial, new ArrayList<>());
            }
            groupBefore.get(initial).add(page);
        }

        // 첫 글자별로 묶기: computeIfAbsent(키, 만드는 함수)
        // 키가 없으면 함수로 값(빈 리스트)을 만들어 넣고 그 값을 돌려줍니다. 키가 있으면 기존 값을 돌려줍니다.
        // 돌려받은 리스트에 바로 add합니다. k -> new ArrayList<>()는 키 k를 받아 새 리스트를 만드는 Function입니다.
        Map<String, List<String>> group = new HashMap<>();
        for (String page : visits) {
            group.computeIfAbsent(page.substring(0, 1), k -> new ArrayList<>()).add(page);
        }
        System.out.println(groupBefore.get("h") + " " + group.get("h")); // [home, home, home] [home, home, home]
        System.out.println(group.get("l")); // [login, login]
    }
}
