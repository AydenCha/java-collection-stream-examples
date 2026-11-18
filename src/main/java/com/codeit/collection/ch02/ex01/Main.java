// 파일 이름: Main.java
package com.codeit.collection.ch02.ex01;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 변수 타입은 인터페이스 List로, 실제 객체는 구현 클래스 ArrayList로 만듭니다(다형성).
        List<String> todo = new ArrayList<>();
        todo.add("회원가입 API");
        todo.add("로그인 API");
        todo.add("회원가입 API");   // List는 같은 값을 다시 넣어도 저장합니다(중복 허용).
        todo.add(1, "DB 설계");     // add(위치, 값): 1번 위치에 끼워 넣고, 원래 있던 요소는 한 칸씩 뒤로 밀립니다.

        // List를 println으로 출력하면 toString()이 호출되어 [요소, 요소] 모양으로 나옵니다.
        System.out.println(todo); // [회원가입 API, DB 설계, 로그인 API, 회원가입 API]

        System.out.println(todo.get(0));  // 회원가입 API (0번 위치의 요소)
        System.out.println(todo.size());  // 4 (요소 개수)

        // contains, indexOf, lastIndexOf는 equals()로 같은 요소인지 비교합니다.
        System.out.println(todo.contains("로그인 API"));       // true
        System.out.println(todo.indexOf("회원가입 API"));      // 0 (앞에서부터 찾은 위치)
        System.out.println(todo.lastIndexOf("회원가입 API"));  // 3 (뒤에서부터 찾은 위치)

        todo.set(2, "로그인 API(JWT)"); // set(위치, 값): 2번 위치의 요소를 새 값으로 바꿉니다.
        todo.remove("회원가입 API");     // remove(값): 앞에서 처음 찾은 하나만 지웁니다.
        System.out.println(todo); // [DB 설계, 로그인 API(JWT), 회원가입 API]

        // 순서대로 꺼내기 1: 인덱스를 쓰는 for 문 (몇 번째인지 필요할 때)
        for (int i = 0; i < todo.size(); i++) {
            System.out.println(i + ": " + todo.get(i));
        }
        // 0: DB 설계
        // 1: 로그인 API(JWT)
        // 2: 회원가입 API

        // 순서대로 꺼내기 2: 향상된 for 문 (인덱스가 필요 없을 때)
        for (String t : todo) {
            System.out.println("- " + t);
        }
        // - DB 설계
        // - 로그인 API(JWT)
        // - 회원가입 API
    }
}
