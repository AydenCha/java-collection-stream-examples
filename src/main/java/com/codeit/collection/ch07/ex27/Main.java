package com.codeit.collection.ch07.ex27;

import java.util.function.BiFunction;
import java.util.function.Function;

class Member {
    private String id;
    private String name;

    // TODO: 아이디만 받는 생성자와, 아이디와 이름을 받는 생성자를 작성하세요.

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}

public class Main {
    public static void main(String[] args) {
        // TODO: 아이디만 받는 생성자를 Function<String, Member> f1에 생성자 참조로 연결하고,
        //       f1.apply("kimcoding")의 결과를 m1에 담으세요.
        Member m1 = null;

        // TODO: 아이디와 이름을 받는 생성자를 BiFunction<String, String, Member> f2에 생성자 참조로 연결하고,
        //       f2.apply("kimcoding", "김코딩")의 결과를 m2에 담으세요.
        Member m2 = null;

        System.out.println(m1);
        System.out.println(m2);
    }
}
