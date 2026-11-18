// 파일 이름: Main.java
package com.codeit.collection.ch02.ex10;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        /*
         * HashSet 기본 사용 예시
         * - 중복을 허용하지 않습니다.
         * - 저장 순서를 보장하지 않습니다.
         * - 인덱스가 없습니다(get(0) 같은 메서드가 없습니다).
         * - 저장할 때 hashCode() -> equals() 순서로 중복을 판단합니다.
         */
        HashSet<String> languages = new HashSet<>();

        // add는 저장에 성공하면 true, 이미 있는 값이라 저장하지 않으면 false를 돌려줍니다.
        System.out.println(languages.add("Java"));   // true
        System.out.println(languages.add("Python")); // true
        System.out.println(languages.add("Java"));   // false (중복이라 저장하지 않음)

        System.out.println(languages.size());            // 2
        System.out.println(languages.contains("Python")); // true

        // HashSet은 순서를 보장하지 않으므로, 이 반복문의 출력 순서는 넣은 순서와 다를 수 있습니다.
        for (String lang : languages) {
            System.out.println(lang);
        }

        // 넣은 순서가 필요하면 LinkedHashSet을 씁니다. 사용법은 HashSet과 같습니다.
        Set<String> ordered = new LinkedHashSet<>();
        ordered.add("Python");
        ordered.add("Java");
        ordered.add("Kotlin");
        ordered.add("Java");          // 중복이라 저장하지 않고, 기존 순서도 그대로입니다.
        System.out.println(ordered);  // [Python, Java, Kotlin]
    }
}
