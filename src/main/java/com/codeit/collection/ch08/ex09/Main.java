// 파일 이름: Main.java
package com.codeit.collection.ch08.ex09;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // 지금까지 쓴 방식: collect에 Collectors.toList()를 넘깁니다.
        List<String> list1 = Stream.of("A", "B").collect(Collectors.toList());

        // Java 16부터는 스트림에 toList()가 있어서 collect 없이 바로 List를 받을 수 있습니다.
        List<String> list2 = Stream.of("A", "B").toList();

        // 담긴 요소와 순서가 같으므로 equals는 true입니다.
        System.out.println(list1.equals(list2)); // true

        /*
         * 차이점: Stream.toList()가 돌려주는 리스트는 수정할 수 없습니다.
         * add, remove 같은 메서드를 실행하면 UnsupportedOperationException이 발생합니다.
         * (Collectors.toList()는 수정 가능 여부를 보장하지 않는다고 javadoc에 적혀 있습니다)
         */
        try {
            list2.add("C");
        } catch (UnsupportedOperationException e) {
            System.out.println("toList() 결과는 수정할 수 없음"); // toList() 결과는 수정할 수 없음
        }

        // 바로잡은 코드: 결과를 고쳐야 한다면 새 ArrayList를 만들면서 요소를 옮겨 담습니다.
        List<String> editable = new ArrayList<>(list2);
        editable.add("C");
        System.out.println(editable); // [A, B, C]
    }
}
