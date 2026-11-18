// 파일 이름: Main.java
package com.codeit.collection.ch07.ex23;

import java.util.function.BiFunction;

class Member {
    private String id;
    private String name;

    // 매개변수 1개 생성자
    Member(String id) {
        this.id = id;
    }

    // 매개변수 2개 생성자
    Member(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Member{id='" + id + "', name='" + name + "'}";
    }
}

public class Main {
    public static void main(String[] args) {
        // BiFunction<String, String, Member>: (String, String) -> Member
        // 같은 Member::new 이지만, 변수 타입이 BiFunction이라서 컴파일러가 매개변수 2개 생성자를 고릅니다.
        // (id, name) -> new Member(id, name) 과 같은 뜻입니다.
        BiFunction<String, String, Member> biFunction = Member::new;

        Member m2 = biFunction.apply("Lambda B", "김코딩");
        System.out.println(m2); // Member{id='Lambda B', name='김코딩'}
    }
}
