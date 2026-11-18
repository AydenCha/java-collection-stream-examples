// 파일 이름: Main.java
package com.codeit.collection.ch11.ex05;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> codes = List.of("CS101", "CS102");

        // 원본은 그대로 두고, new ArrayList<>(원본)으로 복사한 목록에 추가합니다.
        List<String> copy = new ArrayList<>(codes);
        copy.add("CS999");

        System.out.println(codes); // [CS101, CS102] (원본은 바뀌지 않습니다)
        System.out.println(copy);  // [CS101, CS102, CS999]
    }
}
