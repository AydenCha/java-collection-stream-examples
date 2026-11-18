// 파일 이름: Main.java
package com.codeit.collection.ch03.ex09;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
         * ============================================================
         * 4-1-1. 학생 명단 관리 (List 사용)
         * ============================================================
         *
         * 요구사항:
         * - 입력 순서 유지
         * - 중복 허용
         * - 순차 출력
         *
         * List는 순서를 유지하고 중복을 허용하는 자료구조입니다.
         * ArrayList는 내부적으로 배열 기반이며
         * 읽기와 순차 추가에 적합합니다.
         */

        List<String> students = new ArrayList<>();

        students.add("민지");
        students.add("수현");
        students.add("민지");  // 중복 허용

        // 저장된 순서대로 출력됩니다
        for (String name : students) {
            System.out.println(name);
        }
        // 출력
        // 민지
        // 수현
        // 민지
    }
}
