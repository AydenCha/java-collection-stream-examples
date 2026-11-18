// 파일 이름: Main.java
package com.codeit.collection.ch02.ex02;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 자주 하는 실수: List<Integer>에서 remove(1)로 값 1을 지우려고 한다
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.remove(1);           // int를 넘기면 remove(int index)가 호출되어 1번 위치(값 2)가 지워집니다.
        System.out.println(nums); // [1, 3]

        // 바로잡은 코드: 값 1을 지우려면 Integer 객체를 넘겨 remove(Object)가 호출되게 합니다.
        List<Integer> nums2 = new ArrayList<>();
        nums2.add(1);
        nums2.add(2);
        nums2.add(3);
        nums2.remove(Integer.valueOf(1)); // Integer.valueOf(1): int 1을 Integer 객체로 만듭니다.
        System.out.println(nums2);        // [2, 3]
    }
}
