package com.codeit.collection.ch03.ex15;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Order> orderMap = new HashMap<>();

        // TODO: 아래 주문 3건을 orderMap에 넣으세요.
        // ORD001, 민지, 마우스, 키보드
        // ORD002, 수현, 노트북
        // ORD003, 지훈, 모니터, USB 허브, 스피커

        for (Map.Entry<String, Order> entry : orderMap.entrySet()) {
            String orderId = entry.getKey();
            Order order = entry.getValue();

            System.out.println("주문번호: " + orderId);
            System.out.println("고객명: " + order.customerName);
            System.out.println("상품목록: " + order.items);
            System.out.println("---------------------------");
        }
    }
}

class Order {
    // 프로젝트 전체가 컴파일되도록 필드만 미리 선언해 두었습니다.
    String customerName;
    List<String> items;

    // TODO: 고객명(customerName)과 상품 목록(items)을 받는 생성자를 작성하세요.
}
