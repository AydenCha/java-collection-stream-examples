// 파일 이름: Main.java
package com.codeit.collection.ch04.ex01;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Arrays.asList(...): 나열한 값으로 크기가 고정된 List를 만듭니다(add, remove를 호출하면 예외가 발생합니다).
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // [1] 인덱스 for문: i를 직접 늘려 가며 요소를 꺼냅니다(외부 반복).
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
        System.out.println(); // 12345

        // [2] 향상된 for문: 안에서는 Iterator를 쓰지만, 반복을 코드에 직접 적는 외부 반복인 것은 같습니다.
        for (Integer num : list) {
            System.out.print(num);
        }
        System.out.println(); // 12345
    }
}
