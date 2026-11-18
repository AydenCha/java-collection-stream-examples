// 파일 이름: Main.java
package com.codeit.collection.ch07.ex02;

public class Main {
    public static void main(String[] args) {
        // 람다식 (num1, num2) -> num1 + num2 를 익명 객체로 풀어 쓰면 아래와 같은 모양입니다.
        // new Object() { ... }: Object를 상속한 이름 없는 클래스를 만들고, 그 안에 sum 메서드를 정의합니다.
        // 만든 자리에서 바로 .sum(1, 2)를 호출하는 것은 가능합니다.
        int result = new Object() {
            int sum(int num1, int num2) {
                return num1 + num2;
            }
        }.sum(1, 2);

        System.out.println(result); // 3
    }
}
