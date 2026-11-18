// 파일 이름: Main.java
package com.codeit.collection.ch02.ex07;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*
         * ArrayList 주요 메서드 예시
         * - 내부적으로 배열을 사용합니다.
         * - 인덱스로 꺼내는 것이 빠릅니다(O(1): 요소가 몇 개든 한 번에 찾아간다는 뜻).
         * - 중간 삽입, 삭제는 뒤의 요소를 옮겨야 합니다.
         */
        ArrayList<String> list = new ArrayList<>();

        // 요소 추가 (넣은 순서 유지)
        list.add("Java");
        list.add("egg");
        list.add("tree");

        // 인덱스로 요소 조회 (빠름)
        System.out.println(list.get(0)); // Java

        // 현재 저장된 요소 개수
        System.out.println(list.size()); // 3

        // 인덱스 0번 요소("Java") 삭제
        // 삭제하면 뒤의 요소들이 한 칸씩 앞으로 옮겨집니다.
        list.remove(0);

        // 향상된 for 문으로 반복
        // List는 순서를 유지하므로 저장된 순서대로 출력됩니다.
        for (String str : list) {
            System.out.println(str);
        }
        // egg
        // tree
    }
}
