// 파일 이름: Main.java
package com.codeit.collection.ch01.ex02;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};   // 5칸이 모두 찬 배열

        /*
         * 배열은 한 번 생성되면 크기를 변경할 수 없습니다.
         * 크기가 부족해지면 더 큰 배열을 새로 만들고,
         * 기존 데이터를 직접 복사해야 합니다.
         */

        // 더 큰 배열 생성
        int[] newNums = new int[10];

        // 기존 배열 내용을 새 배열로 복사
        // System.arraycopy(원본, 원본 시작 위치, 대상, 대상 시작 위치, 복사할 개수)
        System.arraycopy(nums, 0, newNums, 0, nums.length);

        newNums[5] = 6;   // 이제 6번째 값을 넣을 수 있습니다.

        // Arrays.toString(배열): 배열 내용을 [1, 2, ...] 모양의 문자열로 만들어 줍니다.
        System.out.println(Arrays.toString(newNums)); // [1, 2, 3, 4, 5, 6, 0, 0, 0, 0]

        /*
         * 문제점:
         * - 데이터 수가 자주 바뀌는 환경에서는 매우 번거롭습니다.
         * - 게시글 목록, 회원 목록처럼 동적으로 변하는 데이터에 맞지 않습니다.
         */
    }
}
