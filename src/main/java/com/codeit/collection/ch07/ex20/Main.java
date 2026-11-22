// 파일 이름: Main.java
package com.codeit.collection.ch07.ex20;

import java.util.List;

class Product {
    private final String name;
    private final int price;

    Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    String getName() {
        return name;
    }

    int getPrice() {
        return price;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("무선 마우스", 18000),
                new Product("기계식 키보드", 45000),
                new Product("USB 허브", 22000));

        // 람다식 버전: 5장 4절 실습에서 익명 클래스로 쓴 filter, map, forEach를 람다식으로 바꾼 모양
        products.stream()
                .filter(p -> p.getPrice() >= 20000)
                .map(p -> p.getName())
                .forEach(name -> System.out.println(name));
        // 기계식 키보드
        // USB 허브

        // 메서드 참조 버전
        // filter의 람다식은 비교값 20000이 들어 있어 메서드 하나만 호출하는 모양이 아니므로 그대로 둡니다.
        // p -> p.getName()은 임의 객체의 메서드 참조 Product::getName이 됩니다.
        // name -> System.out.println(name)은 System.out이라는 특정 객체의 메서드 참조 System.out::println이 됩니다.
        products.stream()
                .filter(p -> p.getPrice() >= 20000)
                .map(Product::getName)
                .forEach(System.out::println);
        // 기계식 키보드
        // USB 허브
    }
}
