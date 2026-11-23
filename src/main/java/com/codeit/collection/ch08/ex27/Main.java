package com.codeit.collection.ch08.ex27;

import java.util.Comparator;
import java.util.List;

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
    // 가격이 최고인 상품의 이름, 상품이 없으면 "없음"
    static String topProductName(List<Product> products) {
        // TODO: 스트림의 max와 Optional의 map, orElse를 이어 써서 완성하세요.
        return null;
    }

    public static void main(String[] args) {
        List<Product> products = List.of(
            new Product("키보드", 45000),
            new Product("마우스", 18000),
            new Product("케이블", 12000)
        );
        System.out.println(topProductName(products));  // 완성하면: 키보드
        System.out.println(topProductName(List.of())); // 완성하면: 없음
    }
}
