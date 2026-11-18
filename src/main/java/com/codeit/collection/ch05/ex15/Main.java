// 파일 이름: Main.java
package com.codeit.collection.ch05.ex15;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

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
         * 1) 필터링 + 변환 + 출력
         * - filter: price >= 20000 조건을 통과한 상품만 남김
         * - map: Product를 String(상품명)으로 바꿈
         * - forEach: 최종 연산으로 출력
         */
        products.stream()
                .filter(new Predicate<Product>() {
                    @Override
                    public boolean test(Product product) {
                        return product.getPrice() >= 20000;
                    }
                })
                // Function<Product, String>: Product를 받아 이름(String)을 돌려줍니다.
                .map(new Function<Product, String>() {
                    @Override
                    public String apply(Product product) {
                        return product.getName();
                    }
                })
                .forEach(new Consumer<String>() {
                    @Override
                    public void accept(String name) {
                        System.out.println(name);
                    }
                });
        // 출력:
        // 기계식 키보드
        // USB 허브
    }
}
