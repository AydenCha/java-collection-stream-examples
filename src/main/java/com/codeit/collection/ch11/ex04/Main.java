// 파일 이름: Main.java
package com.codeit.collection.ch11.ex04;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 저장소가 돌려주는 목록처럼 List.of로 만든 목록입니다.
        List<String> codes = List.of("CS101", "CS102");

        try {
            codes.add("CS999"); // List.of 목록은 수정할 수 없어 UnsupportedOperationException이 발생합니다.
        } catch (UnsupportedOperationException e) {
            System.out.println("List.of 목록에는 add할 수 없습니다"); // List.of 목록에는 add할 수 없습니다
        }
        System.out.println(codes); // [CS101, CS102]
    }
}
