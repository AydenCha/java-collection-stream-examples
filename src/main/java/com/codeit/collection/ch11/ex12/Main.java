// 파일 이름: Main.java
package com.codeit.collection.ch11.ex12;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("김밥", "떡볶이");
        List<Double> prices = List.of(3500.0, 4000.0);

        // String.format(형식, 값...): printf와 같은 형식 문자를 쓰고, 출력하는 대신 문자열을 돌려줍니다.
        // %s 문자열, %d 정수, %.1f 소수 첫째 자리까지, %n 줄바꿈
        // %-6s: 6칸을 차지하게 하고 왼쪽에 붙입니다(남는 칸은 오른쪽을 공백으로 채움).
        // 칸 수는 글자 수로 셉니다. 한글은 콘솔에서 영문보다 넓게 보이므로 줄이 조금 어긋나 보일 수 있습니다.
        String line = String.format("[%-6s] %.1f원", names.get(0), prices.get(0));
        System.out.println(line); // [김밥    ] 3500.0원

        // StringBuilder: 문자열을 여러 번 이어 붙일 때 쓰는 클래스입니다.
        // append로 계속 붙이고(append는 자기 자신을 돌려주므로 이어서 호출할 수 있습니다), 마지막에 toString()으로 완성합니다.
        StringBuilder sb = new StringBuilder();
        sb.append("== 메뉴판 ==").append('\n');
        for (int i = 0; i < names.size(); i++) {
            sb.append(String.format("%-6s %.1f%n", names.get(i), prices.get(i)));
        }
        sb.append("============");
        System.out.println(sb.toString());
        // == 메뉴판 ==
        // 김밥     3500.0
        // 떡볶이    4000.0
        // ============
    }
}
