// 파일 이름: Main.java
package com.codeit.collection.ch07.ex15;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> emails = List.of("a@codeit.com", "b@gmail.com", "c@codeit.com");

        Predicate<String> isEmail = s -> s.contains("@");
        Predicate<String> isCodeit = s -> s.endsWith("@codeit.com");

        // and: 두 조건을 모두 만족해야 true인 새 Predicate를 만듭니다.
        Predicate<String> codeitEmail = isEmail.and(isCodeit);
        // negate: 결과를 반대로 뒤집은 새 Predicate를 만듭니다.
        Predicate<String> notCodeit = codeitEmail.negate();

        // filter는 Predicate를 받으므로, 람다식 대신 Predicate 변수를 그대로 넘길 수 있습니다.
        List<String> codeitList = emails.stream()
                .filter(codeitEmail)
                .collect(Collectors.toList());
        System.out.println(codeitList); // [a@codeit.com, c@codeit.com]

        long otherCount = emails.stream()
                .filter(notCodeit)
                .count();
        System.out.println(otherCount); // 1

        // andThen: 앞 Function의 결과를 뒤 Function에 넘기는 새 Function을 만듭니다.
        Function<String, String> trim = s -> s.trim();
        Function<String, Integer> length = s -> s.length();
        Function<String, Integer> trimmedLength = trim.andThen(length);
        System.out.println(trimmedLength.apply("  java  ")); // 4 (앞뒤 공백을 지운 "java"의 글자 수)
    }
}
