// 파일 이름: Main.java
package com.codeit.collection.ch01.ex06;

public class Main {
    public static void main(String[] args) {
        Object[] arr = new Object[3];
        arr[0] = "문자열";
        arr[1] = 123;   // int 123은 Integer 객체로 바뀌어 저장됩니다(1-4-2에서 다룹니다).

        // 바로잡은 코드: 꺼내기 전에 instanceof로 실제 타입을 확인하고, 맞을 때만 형변환합니다.
        // (instanceof는 객체지향 토픽에서 배운 연산자입니다)
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] instanceof String) {
                String s = (String) arr[i];
                System.out.println(i + "번 칸은 문자열: " + s);
            } else if (arr[i] instanceof Integer) {
                Integer n = (Integer) arr[i];
                System.out.println(i + "번 칸은 정수: " + n);
            } else {
                System.out.println(i + "번 칸은 비어 있음"); // 아무것도 넣지 않은 칸은 null입니다.
            }
        }

        /*
         * 이 방법은 오류는 막지만, 꺼낼 때마다 타입을 확인하는 코드를 써야 합니다.
         * 근본적인 해결은 담을 타입을 처음부터 하나로 정해 두는 것이고,
         * 그 방법이 1-4-1의 제네릭입니다.
         */
    }
}
