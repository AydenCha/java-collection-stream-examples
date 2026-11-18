// 파일 이름: Main.java
package com.codeit.collection.ch07.ex06;

@FunctionalInterface
interface MyFunctionalInterface {
    void accept(); // 매개변수 없음, 리턴값 없음
}

public class Main {
    public static void main(String[] args) {
        // accept()에 매개변수가 없으므로 람다식도 빈 괄호 ()로 시작합니다.
        // 중괄호 { } 안에 accept()가 호출됐을 때 실행할 코드를 적습니다.
        MyFunctionalInterface example = () -> {
            System.out.println("람다식의 본문이 실행됩니다.");
        };

        // 람다식을 변수에 담은 것만으로는 실행되지 않습니다. accept()를 호출해야 본문이 실행됩니다.
        example.accept(); // 람다식의 본문이 실행됩니다.
    }
}
