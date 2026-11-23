package com.codeit.collection.ch03.ex12;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<String> rawList = List.of("A", "B", "A", "C");

        Set<String> uniqueSet = new HashSet<>(); // TODO: rawList의 중복을 없앤 Set을 만들도록 이 줄을 고치세요.

        System.out.println(uniqueSet); // 예상 출력: [A, B, C] (순서는 다를 수 있음)
    }
}
