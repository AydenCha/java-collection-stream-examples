// 파일 이름: Main.java
package com.codeit.collection.ch02.ex15;

import java.util.HashSet;
import java.util.Set;

// 1. 데이터 구조: 이메일이 같으면 같은 회원으로 판단하도록 equals와 hashCode를 재정의합니다.
class User {
    String email;

    User(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        // User 타입인지 확인하고, 맞으면 형변환해서 이메일을 비교합니다.
        return o instanceof User && this.email.equals(((User) o).email);
    }

    @Override
    public int hashCode() {
        // equals에서 비교한 필드(email)로 계산해야 "equals가 true면 hashCode도 같다"는 규칙이 지켜집니다.
        return email.hashCode();
    }

    @Override
    public String toString() {
        return "User(" + email + ")";
    }
}

public class Main {
    public static void main(String[] args) {
        Set<User> users = new HashSet<>();

        // 2. 가입 처리: add의 반환값으로 새로 가입했는지 바로 알 수 있습니다.
        System.out.println(users.add(new User("java@codeit.com")));   // true
        System.out.println(users.add(new User("spring@codeit.com"))); // true
        System.out.println(users.add(new User("java@codeit.com")));   // false (중복 가입 시도)

        // 3. 결과 확인: contains도 equals와 hashCode로 같은 회원을 찾습니다.
        System.out.println("총 가입자 수: " + users.size()); // 총 가입자 수: 2
        System.out.println("spring 가입 여부: " + users.contains(new User("spring@codeit.com"))); // spring 가입 여부: true

        // 4. 회원 탈퇴: 새로 만든 객체를 넘겨도 이메일이 같으면 지워집니다.
        users.remove(new User("java@codeit.com"));
        System.out.println("남은 유저: " + users); // 남은 유저: [User(spring@codeit.com)]
    }
}
