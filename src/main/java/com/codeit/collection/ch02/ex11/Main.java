// 파일 이름: Main.java
package com.codeit.collection.ch02.ex11;

import java.util.HashSet;
import java.util.Set;

/*
 * ============================================================
 * equals / hashCode 미구현 시 중복 제거 실패 예시
 * ============================================================
 *
 * 문제 상황:
 * - 서로 다른 메모리 주소에 생성된 객체는
 *   기본적으로 다른 객체로 인식됩니다.
 * - Object의 기본 equals()는 주소 비교
 * - 따라서 중복 제거가 되지 않습니다.
 */

class User {
    String name;

    public User(String name) {
        this.name = name;
    }
    // equals와 hashCode를 재정의하지 않았습니다. Object에게서 물려받은 것을 그대로 씁니다.
}

public class Main {
    public static void main(String[] args) {
        Set<User> users = new HashSet<>();

        users.add(new User("Alice")); // 객체 1
        users.add(new User("Alice")); // 객체 2 (이름 같지만 주소 다름)

        // equals / hashCode 미구현 → 중복 제거 실패
        System.out.println(users.size()); // 2
    }
}
