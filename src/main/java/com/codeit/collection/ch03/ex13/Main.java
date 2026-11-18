// 파일 이름: Main.java
package com.codeit.collection.ch03.ex13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        /*
         * ============================================================
         * 4-2-2. Set -> List (정렬 목적)
         * ============================================================
         *
         * Set은 순서를 보장하지 않습니다.
         * 정렬이 필요하면 List로 변환 후 정렬합니다.
         */

        Set<String> nameSet = Set.of("홍길동", "김철수", "이영희");

        // Set.of로 만든 Set은 수정할 수 없으므로, ArrayList 생성자에 넘겨 수정할 수 있는 List로 복사합니다.
        List<String> nameList = new ArrayList<>(nameSet);

        // 오름차순 정렬 (2장의 Collections.sort)
        Collections.sort(nameList);

        System.out.println(nameList); // [김철수, 이영희, 홍길동] (가나다순)
    }
}
