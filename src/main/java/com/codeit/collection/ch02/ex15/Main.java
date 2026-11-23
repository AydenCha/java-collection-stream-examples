package com.codeit.collection.ch02.ex15;

import java.util.HashSet;
import java.util.Set;

class User {
    String email;

    User(String email) {
        this.email = email;
    }

    // TODO 1. 이메일이 같으면 같은 회원이 되도록 equals와 hashCode 재정의
}

public class Main {
    public static void main(String[] args) {
        Set<User> users = new HashSet<>();

        // TODO 2. java@codeit.com, spring@codeit.com, java@codeit.com 순서로 가입(add)

        // TODO 3. 가입자 수와 spring@codeit.com 가입 여부 출력

        // TODO 4. java@codeit.com 탈퇴(remove)
    }
}
