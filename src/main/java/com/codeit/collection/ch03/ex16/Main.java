// 파일 이름: Main.java
package com.codeit.collection.ch03.ex16;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                new Purchase("지훈", "마우스", 18000));

        // 값이 List인 Map: 고객 이름 하나에 구매 여러 건을 묶습니다.
        Map<String, List<Purchase>> byCustomer = new HashMap<>();

        try {
            for (Purchase p : purchases) {
                // 잘못된 코드: 처음 보는 고객이면 get 결과가 null이라 add를 호출할 수 없습니다.
                byCustomer.get(p.customer).add(p);
            }
        } catch (NullPointerException e) {
            System.out.println("NullPointerException 발생"); // NullPointerException 발생
        }
    }
}
