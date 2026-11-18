// 파일 이름: Main.java
package com.codeit.collection.ch08.ex01;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("java", "sql", "mybatis", "jdbc", "spring", "java", "mybatis");

        list.stream()
            /* * [중간 연산] distinct()
             * - 스트림 내의 중복된 요소를 찾아 제거합니다.
             * - "java"와 "mybatis"가 두 번씩 등장하지만, 결과 스트림에는 하나씩만 남게 됩니다.
             */
            .distinct() 
            /* * [최종 연산] forEach()
             * - 중복이 제거된 "java", "sql", "mybatis", "jdbc", "spring"을 순차적으로 출력합니다.
             */
            .forEach(System.out::println);
    }
}
