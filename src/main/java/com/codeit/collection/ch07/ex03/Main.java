// 파일 이름: Main.java
package com.codeit.collection.ch07.ex03;

public class Main {
    public static void main(String[] args) {
        // 익명 클래스 안에 sum 메서드를 만들었지만, 참조 변수 obj의 타입은 Object입니다.
        // 변수 타입이 Object이면 Object에 선언된 메서드(toString, equals 등)만 호출할 수 있습니다.
        Object obj = new Object() {
            int sum(int num1, int num2) {
                return num1 + num2;
            }
        };

        // 아래 줄의 주석을 풀면 컴파일 오류가 납니다. Object에는 sum 메서드가 없기 때문입니다.
        // obj.sum(1, 2);

        System.out.println(obj != null); // true (객체는 만들어졌지만 sum을 호출할 방법이 없습니다)
    }
}
