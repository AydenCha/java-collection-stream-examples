// 파일 이름: Main.java
package com.codeit.collection.ch07.ex09;

@FunctionalInterface
interface MyFunctionalInterface {
    int accept(int x, int y); // 매개변수 2개, 리턴값 int
}

public class Main {
    public static void main(String[] args) {
        MyFunctionalInterface example;

        // 실행문이 여러 줄이면 중괄호와 return이 필요합니다.
        example = (x, y) -> {
            int result = x + y;
            return result;
        };
        int result1 = example.accept(2, 5);
        System.out.println(result1); // 7

        // 중괄호를 쓰면 실행문이 return 한 줄이어도 return을 적어야 합니다.
        example = (x, y) -> { return x + y; };
        int result2 = example.accept(2, 5);
        System.out.println(result2); // 7

        // 결과를 돌려주는 식 하나뿐이면 중괄호와 return을 함께 생략할 수 있습니다.
        example = (x, y) -> x + y;
        int result3 = example.accept(2, 5);
        System.out.println(result3); // 7

        // 다른 메서드를 호출해 그 결과를 돌려줄 수도 있습니다. 매개변수와 리턴 타입만 맞으면 됩니다.
        example = (x, y) -> sum(x, y);
        int result4 = example.accept(2, 5);
        System.out.println(result4); // 7
    }

    // 람다식 본문에서 호출할 일반 메서드
    public static int sum(int x, int y) {
        return x + y;
    }
}
