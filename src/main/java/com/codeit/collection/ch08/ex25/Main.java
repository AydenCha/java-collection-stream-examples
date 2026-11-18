// 파일 이름: Main.java
package com.codeit.collection.ch08.ex25;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

class Product {
    private String name;
    private int price;

    Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    String getName() { return name; }
    int getPrice() { return price; }
}

public class Main {
    public static void main(String[] args) {
        List<Product> products = List.of(
            new Product("키보드", 45000),
            new Product("마우스", 18000),
            new Product("케이블", 12000)
        );

        /*
         * [최종 연산] min(Comparator), max(Comparator)
         * - 1-2에서 본 Comparator 기준으로 최솟값(최댓값)인 요소 하나를 찾습니다.
         * - 스트림이 비어 있으면 찾을 요소가 없으므로 결과는 Optional<Product>입니다.
         */
        Optional<Product> cheapest = products.stream()
            .min(Comparator.comparingInt(Product::getPrice));

        // map으로 상자 안의 Product를 이름(String)으로 바꾸고, 비어 있으면 "없음"을 씁니다.
        System.out.println(cheapest.map(Product::getName).orElse("없음")); // 케이블

        // 상품이 하나도 없을 때: min의 결과가 빈 Optional이므로 map은 건너뛰고 orElse의 값이 쓰입니다.
        List<Product> noProducts = List.of();
        String name = noProducts.stream()
            .min(Comparator.comparingInt(Product::getPrice))
            .map(Product::getName)
            .orElse("없음");
        System.out.println(name); // 없음
    }
}
