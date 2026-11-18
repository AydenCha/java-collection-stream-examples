// 파일 이름: Main.java
// List와 ArrayList는 java.util 패키지에 있으므로 import가 필요합니다.
package com.codeit.collection.ch01.ex08;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // List<int> scores = new ArrayList<>(); // 컴파일 오류: <> 안에는 int 같은 기본형을 쓸 수 없습니다.
        List<Integer> scores = new ArrayList<>(); // 그래서 int를 객체로 감싼 래퍼 클래스 Integer를 씁니다.

        scores.add(90);   // 오토박싱: int 90이 Integer 객체로 자동 변환되어 저장됩니다.
        scores.add(85);

        int first = scores.get(0);   // 오토언박싱: 꺼낸 Integer 객체가 int 값으로 자동 변환됩니다.
        int sum = first + scores.get(1);
        System.out.println(sum); // 175

        // 래퍼 클래스는 문자열을 숫자로 바꾸는 메서드도 가지고 있습니다.
        int age = Integer.parseInt("25");
        System.out.println(age + 1); // 26
    }
}
