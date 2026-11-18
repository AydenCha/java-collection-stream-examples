// 파일 이름: Main.java
package com.codeit.collection.ch02.ex04;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // List.of(...): 나열한 값으로 리스트를 만듭니다. 이렇게 만든 리스트는 수정할 수 없습니다.
        List<String> fixed = List.of("a", "b");
        try {
            fixed.add("c"); // 추가, 삭제, 교체를 시도하면 UnsupportedOperationException이 발생합니다.
        } catch (UnsupportedOperationException e) {
            System.out.println("List.of로 만든 리스트는 수정할 수 없습니다"); // List.of로 만든 리스트는 수정할 수 없습니다
        }

        // 바로잡은 방법: new ArrayList<>(리스트)로 내용을 복사해 수정할 수 있는 리스트를 만듭니다.
        List<String> editable = new ArrayList<>(fixed);
        editable.add("c");
        System.out.println(editable); // [a, b, c]
    }
}
