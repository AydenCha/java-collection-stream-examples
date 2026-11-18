// 파일 이름: Main.java
package com.codeit.collection.ch02.ex13;

/*
 * record 사용 예시 (equals, hashCode 자동 생성)
 * record는
 * - 괄호 안에 적은 필드를 final로 선언하고
 * - 생성자, 필드 이름과 같은 조회 메서드, equals, hashCode, toString을 자동으로 만들어 줍니다.
 * - 값이 바뀌지 않는(불변) 데이터 객체에 알맞습니다.
 */
import java.util.HashSet;
import java.util.Set;

// record 이름(필드 목록) { } 한 줄로 선언합니다. 괄호 안에 적은 것이 필드가 됩니다.
record User(String name) { }

public class Main {
    public static void main(String[] args) {
        Set<User> users = new HashSet<>();

        users.add(new User("Alice"));
        users.add(new User("Alice")); // 중복

        // equals, hashCode가 자동으로 만들어져 있어 중복이 걸러집니다.
        System.out.println("Set 크기: " + users.size()); // Set 크기: 1

        // toString도 자동으로 만들어집니다.
        // users.iterator().next(): Set에는 인덱스가 없으므로 Iterator(1-4)로 첫 요소를 꺼냅니다.
        System.out.println("출력 결과: " + users.iterator().next()); // 출력 결과: User[name=Alice]
    }
}
