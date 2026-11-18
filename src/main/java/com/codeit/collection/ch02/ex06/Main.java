// 파일 이름: Main.java
package com.codeit.collection.ch02.ex06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
         * ============================================================
         * ArrayList 생성 예시
         * ============================================================
         */

        // 기본 생성자: 내부 배열의 기본 용량으로 시작
        ArrayList<String> list1 = new ArrayList<>();

        // 초기 용량 지정: 미리 공간을 확보하여 재할당 비용을 줄일 수 있습니다
        // (30은 "미리 준비해 둘 칸 수"이고, 들어 있는 요소 수가 아닙니다)
        ArrayList<String> list2 = new ArrayList<>(30);

        // 실무에서는 변수 타입을 인터페이스 List로 선언하는 방식을 주로 씁니다.
        // 나중에 구현체를 LinkedList 등으로 바꿔도 이 줄의 오른쪽만 고치면 됩니다.
        List<String> list3 = new ArrayList<>();
        List<String> list4 = new LinkedList<>();

        System.out.println(list1.size()); // 0
        System.out.println(list2.size()); // 0 (용량을 30으로 잡았어도 요소는 0개)
        System.out.println(list3.isEmpty() + " " + list4.isEmpty()); // true true
    }
}
