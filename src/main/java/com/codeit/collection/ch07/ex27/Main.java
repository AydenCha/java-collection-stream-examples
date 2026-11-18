// 파일 이름: Main.java
package com.codeit.collection.ch07.ex27;

import java.util.function.BiFunction;
import java.util.function.Function;

class Member {
    private String id;   // 회원 아이디
    private String name; // 회원 이름

    // 매개변수 1개 생성자, 디스크립터: (String) -> Member
    public Member(String id) {
        this.id = id;
    }

    // 매개변수 2개 생성자, 디스크립터: (String, String) -> Member
    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}

public class Main {
    public static void main(String[] args) {
        // Function<String, Member>: (String) -> Member
        // 람다식으로 쓰면 id -> new Member(id), 생성자 참조로 줄이면 Member::new
        Function<String, Member> f1 = Member::new;
        Member m1 = f1.apply("kimcoding"); // new Member("kimcoding")

        // BiFunction<String, String, Member>: (String, String) -> Member
        // 람다식으로 쓰면 (id, name) -> new Member(id, name), 생성자 참조로 줄이면 똑같이 Member::new
        BiFunction<String, String, Member> f2 = Member::new;
        Member m2 = f2.apply("kimcoding", "김코딩"); // new Member("kimcoding", "김코딩")

        // println에 객체를 넘기면 toString()의 결과가 출력됩니다.
        System.out.println(m1); // ID: kimcoding, Name: null
        System.out.println(m2); // ID: kimcoding, Name: 김코딩
    }
}
