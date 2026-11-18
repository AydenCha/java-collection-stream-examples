// 파일 이름: Main.java
package com.codeit.collection.ch01.ex07;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
         * 1-4-2. 제네릭을 통한 타입 안전성
         *
         * 제네릭(Generic)을 사용하면
         * 저장 가능한 타입을 컴파일 시점에 제한할 수 있습니다.
         */

        List<String> list = new ArrayList<>();
        list.add("hello");

        // list.add(123); // 컴파일 오류 발생 (List<String>에는 String만 넣을 수 있습니다)

        // 꺼낼 때도 형변환이 필요 없습니다. 컴파일러가 String임을 알고 있습니다.
        String first = list.get(0);
        System.out.println(first); // hello

        /*
         * 장점:
         * - 잘못된 타입 저장을 컴파일 단계에서 차단
         * - 런타임 오류 예방
         */
    }
}
