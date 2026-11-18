// 파일 이름: Main.java
package com.codeit.collection.ch07.ex22;

import java.util.function.Function;

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
        // Function<String, Member>: (String) -> Member
        // 매개변수 1개 생성자 Member(String id)와 모양이 맞습니다.
        // Member::new 는 id -> new Member(id) 와 같은 뜻입니다.
        Function<String, Member> function = Member::new;

        Member m1 = function.apply("Lambda A"); // new Member("Lambda A")가 실행됩니다.
        System.out.println(m1); // Member{id='Lambda A', name='null'}
    }
}
