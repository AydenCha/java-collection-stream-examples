// 파일 이름: Main.java
package com.codeit.collection.ch05.ex01;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;   // forEach에 넘길 인터페이스(4장)
import java.util.function.Predicate;  // filter에 넘길 인터페이스(4장)

/*
 * 중간 연산 filter()
 * - 역할: 조건(Predicate)에 맞는 요소만 걸러 냅니다.
 * - 반환 타입: Stream(또 다른 스트림)이라서 뒤에 연산을 이어 붙일 수 있습니다.
 * - 조건이 true인 요소만 다음 단계로 넘어갑니다.
 */
public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("김코딩", "이자바", "박해커", "김코딩", "박해커");

        names.stream() // 1. 스트림 생성
                // 2. 중간 연산: Predicate<String>을 익명 클래스로 구현해 넘깁니다.
                //    test가 true를 돌려준 요소만 남습니다.
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String name) {
                        // name.charAt(0): 문자열의 첫 글자. 한 글자(char)는 작은따옴표로 적습니다.
                        return name.charAt(0) == '김';
                    }
                })
                // 3. 최종 연산: Consumer<String>을 익명 클래스로 구현해 넘깁니다.
                //    accept는 요소를 받아 출력만 하고 아무것도 돌려주지 않습니다(void).
                .forEach(new Consumer<String>() {
                    @Override
                    public void accept(String name) {
                        System.out.println(name);
                    }
                });
        // 출력:
        // 김코딩
        // 김코딩
    }
}
