// 파일 이름: Main.java
package com.codeit.collection.ch05.ex14;

import java.util.List;

/*
 * 상품(Product) 클래스
 * - 상품명(name)과 가격(price)을 관리합니다.
 * - 스트림 실습에서 filter와 map의 대상이 됩니다.
 */
class Product {

    private String name;  // 상품 이름
    private int price;    // 상품 가격(원)

    // 생성자: name, price로 상품 정보를 초기화합니다.
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // getter: filter 조건(getPrice())과 map에서 이름 꺼내기(getName())에 씁니다.
    public String getName() { return name; }
    public int getPrice() { return price; }

    // 객체를 출력할 때 "무선 마우스 - 18000원" 형태로 보입니다.
    @Override
    public String toString() {
        return name + " - " + price + "원";
    }
}

public class Main {
    public static void main(String[] args) {
        // 데이터 소스 준비: List.of(...)로 테스트용 상품 목록을 만듭니다.
        List<Product> products = List.of(
                new Product("무선 마우스", 18000),
                new Product("기계식 키보드", 45000),
                new Product("HDMI 케이블", 12000),
                new Product("USB 허브", 22000)
        );

        System.out.println("상품 수: " + products.size()); // 상품 수: 4

        // TODO 1 (4-3): 가격이 20000원 이상인 상품만 남기고, 상품 이름만 출력
        // TODO 2 (4-4): 같은 결과를 List<String>으로 수집해 출력
    }
}
