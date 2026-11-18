// 파일 이름: Main.java
package com.codeit.collection.ch08.ex12;

import java.util.List;
import java.util.stream.Collectors;

class Member {
    private String memberId;
    private String memberName;

    Member(String memberId, String memberName) {
        this.memberId = memberId;
        this.memberName = memberName;
    }

    String getMemberName() { return memberName; }
}

public class Main {
    public static void main(String[] args) {
        List<Member> members = List.of(
            new Member("m1", "홍길동"),
            new Member("m2", "이몽룡")
        );

        String result = members.stream()
            // 1. Member 객체에서 이름(String)만 추출
            .map(Member::getMemberName)
            /*
             * [최종 연산] collect(Collectors.joining(구분자, 접두사, 접미사))
             * - 구분자(", "): 각 요소 사이에 쉼표와 공백 추가
             * - 접두사("["): 결과 문자열 맨 앞에 붙임
             * - 접미사("]"): 결과 문자열 맨 뒤에 붙임
             * - joining은 문자열 스트림에서만 쓸 수 있어서, 먼저 map으로 이름을 뽑았습니다.
             */
            .collect(Collectors.joining(", ", "[", "]"));

        System.out.println(result); // 출력: [홍길동, 이몽룡]
    }
}
