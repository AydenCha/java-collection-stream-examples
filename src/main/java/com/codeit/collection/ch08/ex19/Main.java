// 파일 이름: Main.java
package com.codeit.collection.ch08.ex19;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<String> optString = Optional.of("java");
        // get(): 알맹이를 바로 꺼냄. 비어 있다면 NoSuchElementException 발생! (가급적 지양)
        System.out.println(optString.get()); // java

        String nullName = null;
        /*
         * orElse(T other): 권장하는 방식 가운데 하나입니다.
         * "값이 있으면 꺼내고, 없으면 준비한 'kimcoding'을 대신 써라"는 뜻입니다.
         */
        String name = Optional.ofNullable(nullName).orElse("kimcoding");
        System.out.println(name); // kimcoding
    }
}
