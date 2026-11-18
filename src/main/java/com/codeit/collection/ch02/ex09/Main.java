// 파일 이름: Main.java
package com.codeit.collection.ch02.ex09;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. 리스트 생성: 변수 타입은 인터페이스 List로 선언합니다.
        // 나중에 구현 클래스를 바꿔도 이 줄의 오른쪽만 고치면 됩니다.
        List<String> inventory = new ArrayList<>();

        // 2. 상품 입고 (넣은 순서 유지)
        inventory.add("Coke");
        inventory.add("Milk");
        inventory.add("Coffee");
        System.out.println("=== 초기 재고 입고 완료 ===");

        // 3. 재고 확인: contains는 요소가 있으면 true를 돌려줍니다.
        if (inventory.contains("Milk")) {
            System.out.println("결과: [Milk] 재고가 존재합니다.");
        }

        // 4. 수량 파악: size는 저장된 요소 개수를 돌려줍니다.
        System.out.println("현재 입고된 상품 종류: " + inventory.size() + "종");

        // 5. 상품 출고: remove(값)은 equals로 같은 요소를 찾아 지웁니다.
        // 문자열 앞의 \n은 줄바꿈이라 빈 줄이 하나 출력됩니다.
        System.out.println("\n[알림] Milk 상품이 판매되어 출고 처리합니다.");
        inventory.remove("Milk");

        // 6. 전체 점검: List는 순서를 유지하므로 저장 순서대로 출력됩니다.
        System.out.println("=== 현재 창고 잔여 재고 목록 ===");
        for (String item : inventory) {
            System.out.println("- 상품명: " + item);
        }
        // === 초기 재고 입고 완료 ===
        // 결과: [Milk] 재고가 존재합니다.
        // 현재 입고된 상품 종류: 3종
        //
        // [알림] Milk 상품이 판매되어 출고 처리합니다.
        // === 현재 창고 잔여 재고 목록 ===
        // - 상품명: Coke
        // - 상품명: Coffee
    }
}
