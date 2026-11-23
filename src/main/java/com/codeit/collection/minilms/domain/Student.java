package com.codeit.collection.minilms.domain;

/**
 * 학생 한 명을 나타내는 클래스입니다. 학번(studentId)으로 학생을 구분합니다.
 *
 * TODO: 교안 11장 2절의 표를 보고 이 클래스를 완성합니다.
 * 1. 필드를 선언합니다. 만든 뒤에 값을 바꾸지 않으므로 private final로 둡니다.
 *   - long studentId (학번)
 *   - String name (이름)
 *   - int grade (학년)
 *   - String major (전공)
 *   - String gender (성별)
 * 2. 모든 필드를 매개변수로 받는 생성자를 만듭니다. 매개변수 순서는 위 필드 순서와 같게 합니다.
 * 3. 필드마다 getter를 만듭니다(예: getStudentId(), getName()). setter는 만들지 않습니다.
 *    서비스에서 Student::getName 같은 메서드 참조로 쓰므로 이름을 get + 필드 이름으로 맞춥니다.
 * 4. toString()을 재정의해 아래 형식으로 출력되게 합니다. Application의 예상 출력이 이 형식을 따릅니다.
 *    Student{2023001, 홍길동, 1학년, 컴퓨터공학, 남}
 */
public class Student {

    // TODO: 필드, 생성자, getter, toString()을 작성합니다.
}
