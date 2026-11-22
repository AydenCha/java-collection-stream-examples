// 파일 이름: Main.java
package com.codeit.collection.ch02.ex03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // List<int>는 쓸 수 없으므로 래퍼 클래스 Integer를 씁니다(1장). int 값 85, 77 등은 오토박싱되어 저장됩니다.
        List<Integer> scores = new ArrayList<>();
        scores.add(85);
        scores.add(77);
        scores.add(90);
        scores.add(65);

        // Collections: 컬렉션을 다루는 static 메서드를 모아 둔 클래스입니다(Collection 인터페이스와 이름이 비슷하니 주의).
        // Collections.sort(리스트): 작은 값부터 큰 값 순서(오름차순)로 리스트 자체를 정렬합니다.
        Collections.sort(scores);
        System.out.println(scores); // [65, 77, 85, 90]

        // list.sort(정렬 기준): 정렬 기준(Comparator)을 넘겨 정렬합니다.
        // Collections.reverseOrder()는 "큰 값이 앞"이라는 정렬 기준을 만들어 돌려줍니다.
        // 정렬 기준을 직접 만드는 방법은 8장에서 자세히 다룹니다.
        scores.sort(Collections.reverseOrder());
        System.out.println(scores); // [90, 85, 77, 65]

        // 문자열은 사전 순(유니코드 순서)으로 정렬됩니다.
        List<String> names = new ArrayList<>();
        names.add("지훈");
        names.add("민지");
        names.add("서연");
        Collections.sort(names);
        System.out.println(names); // [민지, 서연, 지훈]
    }
}
