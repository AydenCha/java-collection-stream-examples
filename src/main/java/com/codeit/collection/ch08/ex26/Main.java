// 파일 이름: Main.java
// (한 파일에서 바로 실행할 수 있게 클래스 다섯 개를 모았습니다. 실무에서는 클래스마다 파일을 나눕니다)
package com.codeit.collection.ch08.ex26;

import java.util.Optional;

/**
 * 보험사 정보를 관리하는 클래스
 */
class Insurance {
    private String companyName; // 보험사 이름

    Insurance(String companyName) {
        this.companyName = companyName;
    }

    String getCompanyName() { return companyName; }
}

/**
 * 자동차 정보를 관리하는 클래스
 */
class Car {
    private String carName;
    private int price;

    /*
     * 자동차가 보험에 가입되어 있지 않을 수 있으므로 Optional을 사용합니다.
     * 데이터 중첩(Member -> Car -> Insurance)의 연결 고리입니다.
     */
    private Optional<Insurance> insurance;

    Car(String carName, int price, Optional<Insurance> insurance) {
        this.carName = carName;
        this.price = price;
        this.insurance = insurance;
    }

    String getCarName() { return carName; }
    int getPrice() { return price; }

    // 자동차 보험 가입 정보를 담은 Optional 객체를 돌려줍니다.
    Optional<Insurance> getInsurance() { return insurance; }
}

/**
 * 회원 정보를 관리하는 클래스
 */
class Member {
    private String name; // 필수 값 (일반 String)
    private String id;   // 필수 값 (일반 String)

    /*
     * 회원이 자동차를 소유하지 않을 수도 있으므로 Optional로 선언했습니다.
     * (중첩 체이닝을 보여 주려고 필드에 Optional을 쓴 예외입니다.
     *  실무에서는 필드는 일반 타입으로 두고 getter에서 Optional.ofNullable(car)로 돌려줍니다.)
     */
    private Optional<Car> car;

    Member(String name, String id, Optional<Car> car) {
        this.name = name;
        this.id = id;
        this.car = car;
    }

    String getName() { return name; }
    String getId() { return id; }

    // 회원의 자동차 소유 여부를 담은 Optional 객체를 돌려줍니다.
    Optional<Car> getCar() { return car; }
}

/**
 * 회원 관련 데이터를 처리하는 서비스 클래스
 */
class MemberService {
    /*
     * 특정 ID를 가진 회원을 조회합니다.
     * 실무에서는 DB 조회 결과가 없을 수 있으므로 반환 타입을 Optional로 설정합니다.
     * 여기서는 "Ayden"만 있는 회원으로 보고, 다른 id는 빈 Optional을 돌려줍니다.
     */
    Optional<Member> getMember(String id) {
        if (!id.equals("Ayden")) {
            return Optional.empty();
        }
        // 1. 보험 정보 생성 (값이 반드시 있으므로 Optional.of 사용)
        Optional<Insurance> insurance = Optional.of(new Insurance("Samsung direct"));

        // 2. 자동차 정보 생성 (보험 정보를 포함하여 Optional로 감쌈)
        // 60_000_000처럼 숫자 사이에 _를 넣으면 자릿수를 읽기 쉽습니다. 값은 60000000과 같습니다(Java 7부터).
        Optional<Car> car = Optional.of(new Car("XC-60", 60_000_000, insurance));

        // 3. 최종 회원 객체를 생성하여 Optional로 반환
        return Optional.of(new Member("Ayden", "AydenCha", car));
    }
}

public class Main {
    public static void main(String[] args) {
        MemberService memberService = new MemberService();

        /*
         * 객체 안의 객체를 여러 단계 따라갈 때, if (x != null)을 단계마다 겹쳐 쓰지 않아도 되는 코드입니다.
         * 모든 단계가 Optional을 반환하므로 중간에 하나라도 비어 있으면
         * 뒤쪽 연산은 건너뛰고 마지막 orElse가 실행됩니다.
         */
        String insuranceName =
                memberService
                        .getMember("Ayden")               // Optional<Member> 반환
                        .flatMap(Member::getCar)          // Optional<Car>로 평탄화 (getCar가 이미 Optional을 돌려주므로 map 대신 flatMap을 써야 Optional이 겹치지 않습니다)
                        .flatMap(Car::getInsurance)       // Optional<Insurance>로 평탄화
                        .map(Insurance::getCompanyName)   // String으로 변환 (상자 안)
                        .orElse("No result");             // 하나라도 비어 있었다면 이 값이 쓰입니다
        System.out.println(insuranceName); // Samsung direct

        // 없는 회원을 조회하면 첫 단계부터 빈 Optional이므로 orElse의 값이 쓰입니다.
        String unknown =
                memberService
                        .getMember("Unknown")
                        .flatMap(Member::getCar)
                        .flatMap(Car::getInsurance)
                        .map(Insurance::getCompanyName)
                        .orElse("No result");
        System.out.println(unknown); // No result
    }
}
