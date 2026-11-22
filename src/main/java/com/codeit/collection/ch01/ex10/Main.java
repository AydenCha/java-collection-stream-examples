// 파일 이름: Main.java
// List와 ArrayList는 java.util 패키지에 있으므로 import가 필요합니다.
package com.codeit.collection.ch01.ex10;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
         * 1-4-3. 동적 크기 조절
         *
         * ArrayList는 내부적으로 배열을 사용하지만
         * 공간이 부족해지면 자동으로 더 큰 배열을 생성하고 복사합니다.
         */

        // List<Integer>: Integer만 담는 목록이라는 뜻입니다. <> 안에 담을 타입을 적습니다.
        // int 같은 기본형은 적을 수 없어서 래퍼 클래스 Integer를 씁니다.
        List<Integer> list = new ArrayList<>();
        list.add(10); // 크기 자동 확장

        // 크기를 정하지 않았지만 몇 개든 넣을 수 있습니다.
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        System.out.println(list.size()); // 101
    }
}
