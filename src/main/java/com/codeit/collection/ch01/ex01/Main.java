// 파일 이름: Main.java
package com.codeit.collection.ch01.ex01;

public class Main {
    public static void main(String[] args) {
        // 배열은 만들 때 크기를 정해야 합니다. 여기서는 int 5칸입니다.
        int[] nums = new int[5];

        System.out.println(nums.length); // 5 (한 번 정한 크기는 바꿀 수 없습니다)

        // 6번째 칸(인덱스 5)에 값을 넣으려 하면 실행 중에 오류가 발생합니다.
        // nums[5] = 10; // ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
    }
}
