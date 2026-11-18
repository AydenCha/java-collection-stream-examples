// 파일 이름: Main.java
package com.codeit.collection.ch02.ex08;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        /*
         * LinkedList 사용 예시
         * - 노드 기반 연결 구조입니다.
         * - 각 요소(노드)가 이전 노드와 다음 노드의 참조를 가집니다.
         * - 위치를 찾은 뒤의 삽입, 삭제는 참조만 바꾸면 됩니다.
         * - 인덱스로 꺼낼 때는 앞(또는 뒤)에서부터 차례로 따라가야 합니다.
         */
        LinkedList<String> list = new LinkedList<>();

        // 요소 추가 (사용법은 ArrayList와 같습니다. 둘 다 List 인터페이스를 구현했기 때문입니다)
        list.add("Java");
        list.add("egg");
        list.add("tree");

        // 첫 번째 요소 조회
        System.out.println(list.get(0)); // Java

        // 첫 번째 요소 삭제
        // 맨 앞 노드는 바로 찾을 수 있어 연결만 바꾸면 됩니다.
        list.remove(0);

        // 반복 출력
        for (String str : list) {
            System.out.println(str);
        }
        // egg
        // tree
    }
}
