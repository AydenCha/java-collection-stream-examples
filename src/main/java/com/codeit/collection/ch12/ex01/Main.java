// 파일 이름: Main.java
package com.codeit.collection.ch12.ex01;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("김코딩", "이자바", "김스프링", "박해커");

        // 1) 4장: 람다를 배우기 전이라 filter, map에 넘길 동작을 익명 클래스로 만들었습니다.
        //    filter는 Predicate(boolean test), map은 Function(R apply)을 받습니다.
        List<String> before = names.stream()
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String name) {
                        return name.startsWith("김");
                    }
                })
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String name) {
                        return name + "님";
                    }
                })
                .collect(Collectors.toList());
        System.out.println(before); // [김코딩님, 김스프링님]

        // 2) 6장: 같은 동작을 람다로 씁니다. 메서드 이름과 타입 선언이 빠지고 "입력 -> 결과"만 남습니다.
        List<String> after = names.stream()
                .filter(name -> name.startsWith("김"))
                .map(name -> name + "님")
                .collect(Collectors.toList());
        System.out.println(after); // [김코딩님, 김스프링님]

        // 3) 10장: 성(첫 글자)별로 몇 명인지 셉니다.
        //    groupingBy의 두 번째 인자 TreeMap::new는 결과 Map을 TreeMap으로 만들어 키 순서대로 출력되게 합니다.
        //    counting()은 그룹마다 개수를 Long으로 셉니다.
        //    charAt(0)이 돌려주는 char는 Map의 키가 될 때 Character로 오토박싱됩니다.
        Map<Character, Long> countByFamily = names.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0), TreeMap::new, Collectors.counting()));
        System.out.println(countByFamily); // {김=2, 박=1, 이=1}
    }
}
