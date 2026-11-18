// 파일 이름: Main.java
package com.codeit.collection.ch08.ex20;

import java.util.NoSuchElementException;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<String> empty = Optional.empty();

        // 자주 하는 실수: 비어 있는지 확인하지 않고 get()으로 꺼냅니다.
        try {
            System.out.println(empty.get());
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException: " + e.getMessage()); // NoSuchElementException: No value present
        }
    }
}
