// 파일 이름: Main.java
package com.codeit.collection.ch01.ex11;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1-2에서 배열로 for 문을 직접 짜서 하던 일을 ArrayList는 메서드 하나로 합니다.
        List<String> names = new ArrayList<>();
        names.add("민지");   // 맨 뒤에 추가합니다.
        names.add("지훈");
        names.add("수현");
        // 리스트를 println으로 출력하면 [요소, 요소] 모양으로 내용이 나옵니다.
        System.out.println(names); // [민지, 지훈, 수현]

        // contains(값): 들어 있으면 true, 없으면 false
        System.out.println(names.contains("지훈")); // true
        // indexOf(값): 값이 있는 위치(0부터), 없으면 -1
        System.out.println(names.indexOf("수현"));  // 2
        System.out.println(names.indexOf("철수"));  // -1

        // remove(값): 같은 값을 찾아 삭제하고, 뒤의 요소를 자동으로 앞으로 당깁니다.
        names.remove("민지");
        System.out.println(names);        // [지훈, 수현]
        System.out.println(names.size()); // 2 (요소 개수)
    }
}
