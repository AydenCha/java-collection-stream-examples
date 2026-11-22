// 파일 이름: Main.java
package com.codeit.collection.ch12.ex02;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Product {
    private final String code;
    private final String name;

    Product(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
}

class Order {
    private final String customer;
    private final int price;

    Order(String customer, int price) {
        this.customer = customer;
        this.price = price;
    }

    public String getCustomer() { return customer; }
    public int getPrice() { return price; }
}

class Student {
    private final String name;
    private final int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() { return name; }
    public int getScore() { return score; }
}

public class Main {
    public static void main(String[] args) {
        // 1번: Set의 add는 새로 들어가면 true, 이미 있으면 false를 돌려줍니다.
        Set<String> loginIds = new HashSet<>();
        System.out.println(loginIds.add("kim")); // true  (오늘 첫 로그인)
        System.out.println(loginIds.add("kim")); // false (이미 로그인한 ID)
        System.out.println(loginIds.size());     // 1

        // 2번: 상품 코드를 키로, 상품 객체 자신을 값으로 둡니다(p -> p).
        List<Product> products = List.of(new Product("P001", "키보드"), new Product("P002", "마우스"));
        Map<String, Product> byCode = products.stream()
                .collect(Collectors.toMap(Product::getCode, p -> p));
        System.out.println(byCode.get("P002").getName()); // 마우스

        // 3번: filter는 (T) -> boolean 모양, 곧 Predicate<T>를 받습니다.
        Predicate<String> startsWithA = s -> s.startsWith("A");
        System.out.println(startsWithA.test("Anna")); // true

        // 4번: s 말고 고정값 "A"도 넘기므로 Predicate 자리에 메서드 참조를 쓸 수 없습니다.
        //      String::startsWith는 (String, String) -> boolean 모양(BiPredicate)이라
        //      filter가 받는 (T) -> boolean 모양과 맞지 않습니다.
        // List.of("Anna", "Bob").stream().filter(String::startsWith); // 컴파일 오류
        long countA = List.of("Anna", "Bob").stream().filter(s -> s.startsWith("A")).count(); // 람다로 씁니다.
        System.out.println(countA); // 1

        // 5번: 같은 고객이 다시 나오면 Integer::sum으로 금액을 더합니다.
        //      네 번째 인자 TreeMap::new는 결과를 담을 Map을 정합니다.
        //      10장 groupingBy의 가운데 인자와 같은 역할이고, 고객 이름 순서로 출력됩니다.
        List<Order> orders = List.of(new Order("민지", 12000), new Order("지훈", 5000), new Order("민지", 3000));
        Map<String, Integer> totalByToMap = orders.stream()
                .collect(Collectors.toMap(Order::getCustomer, Order::getPrice, Integer::sum, TreeMap::new));
        System.out.println(totalByToMap); // {민지=15000, 지훈=5000}

        // 10장 방식: groupingBy + 다운스트림 reducing(초기값, 꺼낼 값, 합치는 방법)
        Map<String, Integer> totalByGrouping = orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomer, TreeMap::new,
                        Collectors.reducing(0, Order::getPrice, Integer::sum)));
        System.out.println(totalByGrouping); // {민지=15000, 지훈=5000}

        // 6번: 조건 하나로 true(합격), false(불합격) 두 묶음으로 나눕니다.
        //      partitioningBy도 groupingBy처럼 두 번째 인자로 다운스트림을 받습니다.
        //      mapping(Student::getName, Collectors.toList())로 학생 객체 대신 이름만 담습니다.
        List<Student> students = List.of(new Student("서연", 85), new Student("도윤", 55), new Student("하준", 60));
        Map<Boolean, List<String>> passFail = students.stream()
                .collect(Collectors.partitioningBy(s -> s.getScore() >= 60,
                        Collectors.mapping(Student::getName, Collectors.toList())));
        System.out.println(passFail.get(true));  // [서연, 하준]
        System.out.println(passFail.get(false)); // [도윤]
    }
}
