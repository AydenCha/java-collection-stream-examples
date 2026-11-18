// 파일 이름: Main.java
package com.codeit.collection.ch02.ex14;

/*
 * ============================================================
 * record 확장 예시
 * ============================================================
 *
 * 필드를 추가하면 자동으로 equals/hashCode에 반영됩니다.
 * 모든 필드는 final → 불변 객체
 * setter 사용 불가
 */

record User(String email, String name, int age) {

    // 검증 로직이나 일반 메서드는 작성 가능
    // 아래처럼 매개변수 목록 없이 쓰는 생성자를 "컴팩트 생성자"라고 합니다.
    // 필드에 값을 넣는 코드는 자바가 자동으로 붙여 주고, 우리는 검증만 적으면 됩니다.
    public User {
        if (age < 0) {
            throw new IllegalArgumentException("나이는 음수가 될 수 없습니다.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        User user = new User("java@codeit.com", "김코딩", 20);

        // record의 getter는 get 없이 필드 이름과 같은 메서드입니다.
        System.out.println(user.email()); // java@codeit.com
        System.out.println(user);         // User[email=java@codeit.com, name=김코딩, age=20]

        // 세 필드가 모두 같으면 equals가 true입니다.
        System.out.println(user.equals(new User("java@codeit.com", "김코딩", 20))); // true

        try {
            new User("spring@codeit.com", "이자바", -1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // 나이는 음수가 될 수 없습니다.
        }
    }
}
