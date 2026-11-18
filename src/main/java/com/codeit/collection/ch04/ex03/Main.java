// 파일 이름: Main.java
package com.codeit.collection.ch04.ex03;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // List에 있는 숫자 중에서 4보다 큰 짝수의 합계 구하기
        List<Integer> numbers = List.of(1, 3, 6, 7, 8, 11);

        int sum = 0;

        // 반복, 조건 검사, 누적을 모두 직접 작성합니다("어떻게"를 적는 방식).
        for (int number : numbers) {   // 꺼낸 Integer가 int로 오토언박싱됩니다.
            if (number > 4 && number % 2 == 0) {
                sum += number;
            }
        }

        System.out.println("명령형 프로그래밍을 사용한 합계 : " + sum); // 명령형 프로그래밍을 사용한 합계 : 14
    }
}
