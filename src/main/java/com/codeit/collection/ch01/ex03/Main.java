// 파일 이름: Main.java
package com.codeit.collection.ch01.ex03;

class Car {
    String name;
    int speed;

    Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }
}

public class Main {
    public static void main(String[] args) {
        // Car 객체를 5개까지 담을 수 있는 배열입니다. 처음에는 모든 칸이 null입니다.
        Car[] carArray = new Car[5];
        carArray[0] = new Car("페라리", 300);

        System.out.println(carArray[0].name); // 페라리
        System.out.println(carArray[1]);      // null (아직 아무것도 넣지 않은 칸)

        // 배열에는 "이름으로 찾기", "중간 삭제" 같은 기능이 없습니다.
        // 필요하면 for 문으로 직접 만들어야 합니다.
        for (int i = 0; i < carArray.length; i++) {
            if (carArray[i] != null && carArray[i].name.equals("페라리")) {
                System.out.println("페라리의 위치: " + i); // 페라리의 위치: 0
            }
        }
    }
}
