// 파일 이름: Main.java (4-3-2의 Order 클래스를 이 파일 맨 아래에 함께 둡니다)
package com.codeit.collection.ch03.ex15;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * ============================================================
 * 4-3-3. 주문 정보 저장 및 출력
 * ============================================================
 *
 * Map<String, Order> 구조:
 * - Key  : 주문번호
 * - Value: 주문 정보 객체 (안에 상품 목록 List를 가짐)
 *
 * Map은 Key 기반으로 빠르게 주문 조회 가능
 */
public class Main {

    public static void main(String[] args) {

        // Key는 주문번호(String), Value는 주문 객체(Order)
        Map<String, Order> orderMap = new HashMap<>();

        // List.of(...): 나열한 값으로 List를 만듭니다(상품 목록).
        orderMap.put("ORD001", new Order("민지", List.of("마우스", "키보드")));
        orderMap.put("ORD002", new Order("수현", List.of("노트북")));
        orderMap.put("ORD003", new Order("지훈", List.of("모니터", "USB 허브", "스피커")));

        // entrySet 기반 순회
        for (Map.Entry<String, Order> entry : orderMap.entrySet()) {

            String orderId = entry.getKey();
            Order order = entry.getValue();

            System.out.println("주문번호: " + orderId);
            System.out.println("고객명: " + order.customerName);
            System.out.println("상품목록: " + order.items); // List를 출력하면 [a, b] 모양으로 나옵니다.
            System.out.println("---------------------------");
        }
        // 출력 (HashMap이라 주문번호 순서와 다릅니다. 주문번호 순서로 보려면 LinkedHashMap을 씁니다)
        // 주문번호: ORD003
        // 고객명: 지훈
        // 상품목록: [모니터, USB 허브, 스피커]
        // ---------------------------
        // 주문번호: ORD001
        // 고객명: 민지
        // 상품목록: [마우스, 키보드]
        // ---------------------------
        // 주문번호: ORD002
        // 고객명: 수현
        // 상품목록: [노트북]
        // ---------------------------
    }
}

// Order 클래스: 4-3-3의 Main 클래스와 같은 Main.java 파일 안, Main 클래스 아래에 붙여 넣습니다.
// import는 4-3-3 코드 맨 위의 import java.util.List를 함께 씁니다.
/*
 * ============================================================
 * 4-3-2. Order 클래스
 * ============================================================
 *
 * 주문번호는 Map의 Key로 사용됩니다.
 * Order 객체는 고객명과 상품 목록(List)을 가집니다.
 */
class Order {
    String customerName;
    List<String> items;   // 한 주문에 상품이 여러 개일 수 있으므로 List로 둡니다.

    Order(String customerName, List<String> items) {
        this.customerName = customerName;
        this.items = items;
    }
}
