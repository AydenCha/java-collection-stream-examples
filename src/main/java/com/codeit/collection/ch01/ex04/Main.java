// 파일 이름: Main.java
package com.codeit.collection.ch01.ex04;

public class Main {
    public static void main(String[] args) {
        /*
         * Object 배열을 사용하면 모든 타입을 저장할 수 있습니다.
         * (모든 클래스는 Object를 상속하므로 다형성에 의해 어떤 객체든 Object 칸에 담깁니다)
         * 이는 유연하지만 타입 안전성이 떨어집니다.
         */

        Object[] arr = new Object[3];
        arr[0] = "문자열";
        arr[1] = 123;      // int 123은 Integer 객체로 자동 변환되어 들어갑니다(오토박싱).

        System.out.println(arr[0]); // 문자열
        System.out.println(arr[1]); // 123
        // 한 배열에 String과 Integer가 섞여 있어서, 꺼낼 때 어떤 타입인지 알 수 없습니다.
    }
}
