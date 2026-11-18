// 파일 이름: Main.java
package com.codeit.collection.ch03.ex10;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        /*
         * ============================================================
         * 4-1-2. 출석 체크 기록 (Set 사용)
         * ============================================================
         *
         * 요구사항:
         * - 중복 불가
         * - 순서 중요하지 않음
         *
         * Set은 중복을 허용하지 않습니다.
         * HashSet은 순서를 보장하지 않지만 많이 사용됩니다.
         */

        Set<String> attendance = new HashSet<>();

        attendance.add("민지");
        attendance.add("수현");
        attendance.add("민지"); // 중복 -> 저장되지 않음

        System.out.println(attendance.size()); // 2

        // HashSet은 순서를 보장하지 않으므로 넣은 순서와 다르게 출력될 수 있습니다.
        for (String name : attendance) {
            System.out.println(name);
        }
        // 출력 (순서는 달라질 수 있습니다)
        // 민지
        // 수현
    }
}
