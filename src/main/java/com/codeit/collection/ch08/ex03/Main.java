// 파일 이름: Main.java
package com.codeit.collection.ch08.ex03;

import java.util.List;

// Comparable을 구현하지 않은 클래스입니다.
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
            new Product("마우스", 18000)
        );

        try {
            products.stream()
                .sorted() // 기준 없이 정렬: Product는 Comparable이 아니므로 비교할 방법이 없습니다.
                .forEach(p -> System.out.println(p.getName()));
        } catch (ClassCastException e) {
            // 컴파일은 통과하고, 최종 연산(forEach)이 실행될 때 예외가 발생합니다.
            System.out.println("ClassCastException 발생"); // ClassCastException 발생
        }
    }
}
