// 파일 이름: Main.java
package com.codeit.collection.ch08.ex11;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // "java"와 "sql"이 두 번씩 들어 있는 리스트입니다.
        List<String> skills = List.of("java", "sql", "spring", "java", "jpa", "sql");

        /*
         * 기술 이름을 키로, 글자 수를 값으로 모으려고 합니다.
         * 두 번째 "java"가 들어올 때 같은 키가 이미 있으므로
         * toMap은 어느 값을 남길지 몰라 IllegalStateException을 발생시킵니다.
         */
        try {
            Map<String, Integer> lengthBySkill = skills.stream()
                .collect(Collectors.toMap(s -> s, String::length));
            System.out.println(lengthBySkill); // 예외가 먼저 발생하므로 실행되지 않습니다.
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage()); // Duplicate key java (attempted merging values 4 and 4)
        }

        /*
         * 바로잡은 코드: toMap의 세 번째 인자로 "같은 키의 두 값을 하나로 합치는 규칙"을 넘깁니다.
         * - 키: 기술 이름(s -> s)
         * - 값: 처음 나올 때 1(s -> 1)
         * - 합치는 규칙: 이미 있던 값 a와 새 값 b를 더합니다((a, b) -> a + b).
         * 이렇게 하면 기술별 등장 횟수가 됩니다. 3장에서 반복문으로 셌던 등장 횟수를 스트림으로 구한 것입니다.
         */
        Map<String, Integer> countBySkill = skills.stream()
            .collect(Collectors.toMap(s -> s, s -> 1, (a, b) -> a + b));

        // HashMap 출력 순서는 정해져 있지 않으므로 get으로 하나씩 확인합니다.
        System.out.println(countBySkill.get("java"));   // 2
        System.out.println(countBySkill.get("spring")); // 1
        System.out.println(countBySkill.size());        // 4 (java, sql, spring, jpa)
    }
}
