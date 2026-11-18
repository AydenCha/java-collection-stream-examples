// 파일 이름: Main.java
package com.codeit.collection.ch03.ex04;

import java.util.HashMap;
import java.util.Map;

// equals와 hashCode를 재정의하지 않은 키: 학번이 같아도 다른 객체로 취급됩니다.
class PlainId {
    String code;

    PlainId(String code) {
        this.code = code;
    }
}

// 바로잡은 키: 학번(code)이 같으면 같은 키로 봅니다.
class StudentId {
    String code;

    StudentId(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof StudentId)) {
            return false;
        }
        StudentId other = (StudentId) o;
        return code.equals(other.code);
    }

    // HashMap은 hashCode로 칸을 찾고 equals로 확인하므로 둘을 함께 재정의합니다.
    @Override
    public int hashCode() {
        return code.hashCode();
    }
}

public class Main {
    public static void main(String[] args) {
        Map<PlainId, String> plain = new HashMap<>();
        plain.put(new PlainId("2024001"), "민지");
        // 내용이 같은 새 객체로 찾으면 다른 키로 취급되어 null이 나옵니다.
        System.out.println(plain.get(new PlainId("2024001"))); // null

        Map<StudentId, String> fixed = new HashMap<>();
        fixed.put(new StudentId("2024001"), "민지");
        System.out.println(fixed.get(new StudentId("2024001"))); // 민지

        // 같은 학번으로 다시 넣으면 새 키가 생기지 않고 값이 바뀝니다.
        fixed.put(new StudentId("2024001"), "민지(수정)");
        System.out.println(fixed.size()); // 1
    }
}
