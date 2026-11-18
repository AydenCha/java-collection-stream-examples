// 파일 이름: Main.java
package com.codeit.collection.ch01.ex05;

public class Main {
    public static void main(String[] args) {
        Object[] arr = new Object[3];
        arr[0] = "문자열";
        arr[1] = 123;

        /*
         * 컴파일은 통과하지만,
         * 잘못된 타입으로 형변환하면 런타임 오류가 발생합니다
         */
        try {
            String s = (String) arr[1]; // ClassCastException 발생 (실제로는 Integer인데 String으로 바꾸려 함)
            System.out.println(s);
        } catch (ClassCastException e) {
            System.out.println("ClassCastException 발생"); // ClassCastException 발생
        }

        /*
         * 문제점:
         * - 컴파일 시점 대신 실행 시점에 오류가 발생합니다
         * - 안전하지 않은 구조입니다
         */
    }
}
