package com.codeit.collection.minilms.repository;

import com.codeit.collection.minilms.domain.Course;

import java.util.List;

/**
 * 데이터베이스 대신 List로 강의를 보관하는 저장소입니다(Mock DB).
 *
 * TODO: Course 클래스를 먼저 완성한 뒤, 교안 11장 3절의 표를 보고 이 클래스를 완성합니다.
 * 1. 표의 샘플 데이터 5건을 담은 목록을 private static final 필드로 선언합니다.
 *    List.of(...) 안에 new Course(...)를 표의 줄 순서대로 넣습니다. 예: new Course("CS101", "자바프로그래밍", "김철수", 3)
 * 2. getCourses()가 그 목록을 돌려주게 합니다.
 * List.of로 만든 목록은 수정할 수 없습니다. 서비스에서는 이 목록을 읽기만 합니다.
 * 막히면 교안의 "힌트 - 잘 모를 때만"을 펼쳐 봅니다.
 */
public class CourseRepository {

    // TODO: 샘플 데이터 목록을 필드로 선언합니다.

    public static List<Course> getCourses() {
        // TODO: 아래 한 줄을 지우고 위에서 선언한 목록을 돌려줍니다.
        throw new UnsupportedOperationException("TODO: CourseRepository.getCourses() 메서드를 구현하세요. 교안 11장 3절의 표를 참고합니다.");
    }
}
