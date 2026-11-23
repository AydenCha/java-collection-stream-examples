package com.codeit.collection.minilms.domain;

/**
 * 수강 내역 한 건을 나타내는 클래스입니다. Student, Course 객체 대신 학번과 강의 코드만 가집니다.
 *
 * TODO: 교안 11장 2절의 표를 보고 이 클래스를 완성합니다.
 * 1. 필드를 선언합니다. 만든 뒤에 값을 바꾸지 않으므로 private final로 둡니다.
 *   - long studentId (학번)
 *   - String courseCode (강의 코드)
 *   - String semester (학기)
 *   - int score (성적)
 * 2. 모든 필드를 매개변수로 받는 생성자를 만듭니다. 매개변수 순서는 위 필드 순서와 같게 합니다.
 * 3. 필드마다 getter를 만듭니다(예: getStudentId(), getCourseCode()). setter는 만들지 않습니다.
 *    서비스에서 Student::getName 같은 메서드 참조로 쓰므로 이름을 get + 필드 이름으로 맞춥니다.
 * 4. toString()을 재정의해 아래 형식으로 출력되게 합니다. Application의 예상 출력이 이 형식을 따릅니다.
 *    Enrollment{2023001, CS101, 2023-1, 95}
 */
public class Enrollment {

    // TODO: 필드, 생성자, getter, toString()을 작성합니다.
}
