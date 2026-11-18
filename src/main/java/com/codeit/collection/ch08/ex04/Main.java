// 파일 이름: Main.java
package com.codeit.collection.ch08.ex04;

import java.util.Comparator;
import java.util.List;

// 상품 이름과 가격을 가진 클래스입니다. Comparable을 구현하지 않았으므로 정렬 기준이 없습니다.
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
            new Product("허브", 18000),
            new Product("케이블", 12000)
        );

        // 가격 오름차순
        products.stream()
            /*
             * Comparator.comparingInt(Product::getPrice)
             * - 각 상품에서 getPrice()로 꺼낸 int 값을 비교하는 Comparator를 만들어 줍니다.
             * - (a, b) -> a.getPrice() - b.getPrice() 같은 람다를 직접 쓰지 않아도 됩니다.
             * - 가격이 같은 마우스와 허브는 원래 순서(마우스, 허브)를 유지합니다.
             */
            .sorted(Comparator.comparingInt(Product::getPrice))
            .forEach(p -> System.out.println(p.getName() + " " + p.getPrice()));
        // 케이블 12000
        // 마우스 18000
        // 허브 18000
        // 키보드 45000

        System.out.println("---");

        // 가격 내림차순, 가격이 같으면 이름 오름차순
        products.stream()
            /*
             * - .reversed(): 앞에서 만든 기준의 순서를 뒤집습니다(가격 내림차순).
             * - .thenComparing(Product::getName): 앞 기준으로 순위가 같을 때(compare 결과가 0일 때) 쓸 다음 기준입니다.
             *   이름은 String이라 Comparable이므로 사전 순으로 비교됩니다.
             */
            .sorted(Comparator.comparingInt(Product::getPrice).reversed()
                .thenComparing(Product::getName))
            .forEach(p -> System.out.println(p.getName() + " " + p.getPrice()));
        // 키보드 45000
        // 마우스 18000
        // 허브 18000
        // 케이블 12000
    }
}
