package com.codeit.collection.ch03.ex13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> nameSet = Set.of("홍길동", "김철수", "이영희");

        List<String> nameList = new ArrayList<>(); // TODO: nameSet의 요소를 담은 List를 만들도록 이 줄을 고치세요.

        Collections.sort(nameList); // 오름차순 정렬
        System.out.println(nameList); // 예상 출력: [김철수, 이영희, 홍길동]
    }
}
