// 파일 이름: Main.java
package com.codeit.collection.ch02.ex12;

import java.util.HashSet;
import java.util.Set;

/*
 * ============================================================
 * equals / hashCode 오버라이딩으로 중복 제거 해결
 * ============================================================
 *
 * HashSet 동작 원리:
 * 1. hashCode() 비교
 * 2. 같으면 equals() 비교
 *
 * 두 메서드를 반드시 함께 재정의해야 합니다.
 */

class User {
    String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        // 타입 확인 + name 값 비교
        // (User) o: Object 타입 매개변수 o를 User로 형변환해야 name 필드를 꺼낼 수 있습니다.
        return o instanceof User && this.name.equals(((User) o).name);
    }

    @Override
    public int hashCode() {
        // name 기준으로 해시 계산 (이름이 같으면 같은 숫자가 나옵니다)
        return name.hashCode();
    }
}

public class Main {
    public static void main(String[] args) {
        Set<User> users = new HashSet<>();

        users.add(new User("Alice"));
        users.add(new User("Alice")); // 이름이 같으므로 같은 객체로 판단 → 저장되지 않음

        System.out.println(users.size()); // 1
    }
}
