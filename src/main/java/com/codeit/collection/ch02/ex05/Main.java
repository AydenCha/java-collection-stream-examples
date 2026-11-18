// 파일 이름: Main.java
package com.codeit.collection.ch02.ex05;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 잘못된 방법: 향상된 for 문으로 순회하면서 리스트의 remove를 직접 호출
        List<String> wrong = new ArrayList<>();
        wrong.add("DB 설계");
        wrong.add("로그인 API");
        wrong.add("DB 백업");
        wrong.add("회원가입 API");
        try {
            for (String t : wrong) {
                if (t.startsWith("DB")) {
                    wrong.remove(t); // 순회 도중 리스트의 구조가 바뀝니다.
                }
            }
        } catch (ConcurrentModificationException e) {
            // 향상된 for 문은 내부에서 Iterator를 쓰는데, Iterator가 리스트가 바뀐 것을 감지해 예외를 일으킵니다.
            System.out.println("ConcurrentModificationException 발생"); // ConcurrentModificationException 발생
        }

        // 바로잡은 방법: Iterator의 remove로 지웁니다.
        List<String> todo = new ArrayList<>();
        todo.add("DB 설계");
        todo.add("로그인 API");
        todo.add("DB 백업");
        todo.add("회원가입 API");

        // Iterator: 컬렉션의 요소를 하나씩 꺼내 주는 객체입니다. iterator()로 얻습니다.
        Iterator<String> it = todo.iterator();
        while (it.hasNext()) {          // hasNext(): 꺼낼 요소가 남아 있으면 true
            String t = it.next();       // next(): 다음 요소를 꺼냅니다.
            if (t.startsWith("DB")) {
                it.remove();            // remove(): 방금 next()로 꺼낸 요소를 지웁니다.
            }
        }
        System.out.println(todo); // [로그인 API, 회원가입 API]
    }
}
