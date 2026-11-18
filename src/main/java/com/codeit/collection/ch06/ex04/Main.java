// 파일 이름: Main.java
// 람다는 혼자서는 문장이 될 수 없고, 추상 메서드가 하나뿐인 인터페이스 타입의 변수에 담거나 메서드 인자로 넘겨야 합니다.
// 그래서 실행해 볼 수 있게 변수에 담았습니다.
//   Runnable: 매개변수도 반환값도 없는 run() 하나를 가진 인터페이스입니다(java.lang 패키지라 import가 필요 없습니다).
//   Consumer<String>: String 하나를 받아 쓰기만 하고 돌려주는 값은 없는 accept() 하나를 가진 인터페이스입니다(4장).
//   BinaryOperator<Integer>: Integer 두 개를 받아 Integer 하나를 돌려주는 apply() 하나를 가진 인터페이스입니다.
// 이런 인터페이스의 목록은 7장에서 정리합니다.
package com.codeit.collection.ch06.ex04;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        // 매개변수 0개: 괄호 생략 불가
        Runnable start = () -> System.out.println("시작");

        // 매개변수 1개: 타입 생략 가능, 괄호도 생략 가능 (아래 세 줄은 모두 같은 뜻입니다)
        Consumer<String> p1 = (String name) -> System.out.println(name);
        Consumer<String> p2 = (name) -> System.out.println(name);
        Consumer<String> p3 = name -> System.out.println(name);

        // 반환식 1줄: 중괄호와 return 생략 가능
        BinaryOperator<Integer> add = (a, b) -> a + b;

        // 람다를 담은 변수는 그 인터페이스의 메서드를 호출해야 실행됩니다.
        start.run();                           // 시작
        p1.accept("김코딩");                    // 김코딩
        p2.accept("이자바");                    // 이자바
        p3.accept("박해커");                    // 박해커
        System.out.println(add.apply(3, 4));   // 7
    }
}
