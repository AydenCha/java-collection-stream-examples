// 파일 이름: Main.java
package com.codeit.collection.ch08.ex17;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // empty(): 데이터가 없음을 명시적으로 나타낼 때 사용합니다. null 대신 쓰는 안전한 표현입니다.
        // <String>은 "String을 담는 Optional"임을 알려 주는 표기입니다. 왼쪽 변수 타입으로 알 수 있으므로 생략해도 됩니다.
        Optional<String> opt3 = Optional.<String>empty();
        Optional<String> opt4 = Optional.empty();   // 위와 같은 뜻

        System.out.println(opt3);             // Optional.empty
        // isPresent(): 값이 있으면 true, isEmpty(): 비어 있으면 true (isEmpty는 Java 11부터)
        System.out.println(opt3.isPresent()); // false
        System.out.println(opt4.isEmpty());   // true
    }
}
