package com.codeit.collection.ch03.ex14;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("민지", "수현", "지훈", "민지", "수현", "민지");

        Map<String, Integer> nameCountMap = new HashMap<>();

        // TODO: 반복문으로 이름별 등장 횟수를 nameCountMap에 넣으세요.

        System.out.println(nameCountMap);
        // 예상 출력: {지훈=1, 민지=3, 수현=2} (순서는 다를 수 있음)
    }
}
