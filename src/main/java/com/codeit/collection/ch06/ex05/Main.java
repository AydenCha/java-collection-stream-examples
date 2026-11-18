// 파일 이름: Main.java
package com.codeit.collection.ch06.ex05;

public class Main {
    public static void main(String[] args) {
        // 매개변수가 없을 때는 소괄호를 작성해야 합니다(생략 불가).
        // Runnable: 매개변수도 반환값도 없는 메서드 run() 하나를 가진 인터페이스입니다.
        Runnable task = () -> System.out.println("작업 시작!");

        task.run(); // 작업 시작!
    }
}
