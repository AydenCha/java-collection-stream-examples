// 파일 이름: Main.java
package com.codeit.collection.ch05.ex16;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Product {

    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }

    @Override
    public String toString() {
        return name + " - " + price + "원";
    }
}

public class Main {
    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("무선 마우스", 18000),
                new Product("기계식 키보드", 45000),
                new Product("HDMI 케이블", 12000),
                new Product("USB 허브", 22000)
        );

        /*
         * 2) 필터링 + 변환 + 수집
         * - collect(Collectors.toList()): 조건에 맞는 상품명을 List<String>으로 모읍니다.
         * - 스트림은 읽기 전용이며 일회용이므로, 다시 쓰려면 stream()을 새로 호출합니다.
         */
        List<String> filteredProductNames = products.stream()
                .filter(new Predicate<Product>() {
                    @Override
                    public boolean test(Product product) {
                        return product.getPrice() >= 20000;
                    }
                })
                .map(new Function<Product, String>() {
                    @Override
                    public String apply(Product product) {
                        return product.getName();
                    }
                })
                .collect(Collectors.toList());

        System.out.println("추천 상품 목록: " + filteredProductNames); // 추천 상품 목록: [기계식 키보드, USB 허브]
    }
}
