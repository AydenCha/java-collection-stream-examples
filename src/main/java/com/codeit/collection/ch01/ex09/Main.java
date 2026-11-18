// 파일 이름: Main.java
package com.codeit.collection.ch01.ex09;

public class Main {
    public static void main(String[] args) {
        // 자주 하는 실수 1: 래퍼 객체를 ==로 비교한다
        Integer a = 1000;
        Integer b = 1000;
        System.out.println(a == b);      // false (==는 같은 객체인지 비교합니다)
        System.out.println(a.equals(b)); // true  (값을 비교하려면 equals를 씁니다)

        // 자주 하는 실수 2: null인 래퍼 객체를 기본형 변수에 담는다
        Integer point = null;            // 래퍼 클래스 변수에는 null을 넣을 수 있습니다.
        try {
            int p = point;               // 오토언박싱할 값이 없어서 NullPointerException이 발생합니다.
            System.out.println(p);
        } catch (NullPointerException e) {
            System.out.println("null을 int로 바꿀 수 없습니다"); // null을 int로 바꿀 수 없습니다
        }

        // 바로잡은 코드: null인지 먼저 확인하고, null이면 기본값 0을 씁니다.
        int safe = 0;
        if (point != null) {
            safe = point;
        }
        System.out.println(safe); // 0
    }
}
