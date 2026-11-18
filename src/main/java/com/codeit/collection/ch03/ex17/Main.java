// 파일 이름: Main.java
package com.codeit.collection.ch03.ex17;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

// 구매 한 건: 고객, 상품, 가격
class Purchase {
    String customer;
    String product;
    int price;

    Purchase(String customer, String product, int price) {
        this.customer = customer;
        this.product = product;
        this.price = price;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Purchase> purchases = List.of(
                new Purchase("민지", "키보드", 45000),
                new Purchase("지훈", "마우스", 18000),
                new Purchase("민지", "USB 허브", 22000),
                new Purchase("수현", "키보드", 45000),
                new Purchase("지훈", "HDMI 케이블", 12000));

        // LinkedHashMap: HashMap과 쓰는 법은 같고, 넣은 순서를 유지합니다. 결과를 처음 나온 고객 순서로 보려고 씁니다.
        Map<String, List<Purchase>> byCustomer = new LinkedHashMap<>(); // 고객별 구매 목록 (값이 List인 Map)
        Map<String, Integer> totalByCustomer = new LinkedHashMap<>();   // 고객별 합계
        Set<String> products = new HashSet<>();                         // 상품 종류 (중복 제거)

        // 한 번의 반복으로 세 가지를 함께 채웁니다.
        for (Purchase p : purchases) {
            if (!byCustomer.containsKey(p.customer)) {
                byCustomer.put(p.customer, new ArrayList<>()); // 처음 보는 고객이면 빈 목록부터 넣습니다.
            }
            byCustomer.get(p.customer).add(p);                  // 그 고객의 목록을 꺼내 구매를 추가합니다.

            totalByCustomer.put(p.customer, totalByCustomer.getOrDefault(p.customer, 0) + p.price);
            products.add(p.product);
        }

        for (Map.Entry<String, List<Purchase>> entry : byCustomer.entrySet()) {
            String customer = entry.getKey();
            System.out.println(customer + " 구매 " + entry.getValue().size() + "건, 합계 " + totalByCustomer.get(customer) + "원");
        }
        System.out.println("상품 종류 = " + products.size());
        // 출력
        // 민지 구매 2건, 합계 67000원
        // 지훈 구매 2건, 합계 30000원
        // 수현 구매 1건, 합계 45000원
        // 상품 종류 = 4
    }
}
