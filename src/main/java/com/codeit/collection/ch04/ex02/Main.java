// 파일 이름: Main.java
package com.codeit.collection.ch04.ex02;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // 생성: 컬렉션의 stream() 메서드로 스트림을 만듭니다.
        Stream<Integer> stream = list.stream();

        // forEach(최종 연산): 요소를 하나씩 꺼내 아래 객체의 accept 메서드에 넘깁니다.
        // 반복은 스트림이 맡고, 우리는 "요소 하나로 무엇을 할지"만 익명 클래스로 적어 넘깁니다.
        // Consumer는 java.util.function 패키지의 인터페이스이고, 구현할 메서드는 반환값이 없는 accept 하나입니다(8-3에서 자세히 다룹니다).
        stream.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer num) {
                System.out.print(num);
            }
        });
        System.out.println(); // 12345

        // 보통은 스트림을 변수에 담지 않고 바로 이어서 씁니다.
        // 위의 stream은 forEach로 이미 사용해서 다시 쓸 수 없으므로 list.stream()으로 새로 만듭니다(3-3에서 다룹니다).
        list.stream().forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer num) {
                System.out.print(num);
            }
        });
        System.out.println(); // 12345
    }
}
