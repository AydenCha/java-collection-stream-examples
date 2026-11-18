// 파일 이름: Main.java
package com.codeit.collection.ch06.ex15;

class Printer {
    // this를 출력했을 때 알아보기 쉽게 toString을 오버라이딩합니다.
    @Override
    public String toString() {
        return "Printer 객체";
    }

    void show() {
        Runnable anon = new Runnable() {
            @Override
            public void run() {
                // 익명 클래스 안의 this는 익명 클래스로 만든 객체(Runnable 구현체) 자신입니다.
                System.out.println("익명 클래스의 this는 Runnable인가? " + (this instanceof Runnable));
            }
        };

        // 람다 본문의 this는 람다를 감싼 코드(show 메서드)의 this와 같습니다. 그래서 Printer 객체입니다.
        Runnable lambda = () -> System.out.println("람다의 this: " + this);

        anon.run();   // 익명 클래스의 this는 Runnable인가? true
        lambda.run(); // 람다의 this: Printer 객체
    }
}

public class Main {
    public static void main(String[] args) {
        new Printer().show();
    }
}
