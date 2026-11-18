// 파일 이름: Main.java
package com.codeit.collection.ch11.ex01;

import java.util.List;

// 학생 한 명을 나타내는 도메인 클래스입니다.
// 값을 바꿀 일이 없으므로 필드를 final로 두고 setter는 만들지 않습니다(만든 뒤에는 값이 바뀌지 않는 불변 객체).
class Student {
    private final long studentId; // 학번. 수강 내역(Enrollment)이 이 학번으로 학생을 가리킵니다.
    private final String name;
    private final int grade;
    private final String major;
    private final String gender;

    Student(long studentId, String name, int grade, String major, String gender) {
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
        this.major = major;
        this.gender = gender;
    }

    // getter: 서비스에서 Student::getMajor처럼 메서드 참조로 씁니다.
    long getStudentId() { return studentId; }
    String getName() { return name; }
    int getGrade() { return grade; }
    String getMajor() { return major; }
    String getGender() { return gender; }

    @Override
    public String toString() {
        return "Student{" + studentId + ", " + name + ", " + grade + "학년, " + major + ", " + gender + "}";
    }
}

// DB 대신 List로 데이터를 보관하는 저장소입니다(Mock DB).
class StudentRepository {
    // static final: 프로그램 전체에 하나만 두고 다른 목록으로 바꾸지 않습니다.
    // List.of로 만든 목록은 add, remove를 할 수 없어서 누군가 실수로 데이터를 바꿀 수 없습니다.
    private static final List<Student> STUDENTS = List.of(
            new Student(2023001, "홍길동", 1, "컴퓨터공학", "남"),
            new Student(2023002, "김민지", 2, "경영학", "여"),
            new Student(2023003, "이수빈", 1, "컴퓨터공학", "여"),
            new Student(2023004, "최준영", 3, "기계공학", "남"),
            new Student(2023005, "박지현", 2, "컴퓨터공학", "여"));

    // 서비스를 만들 때 이 목록을 넘겨줍니다.
    static List<Student> getStudents() {
        return STUDENTS;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = StudentRepository.getStudents();
        System.out.println(students.size()); // 5
        System.out.println(students.get(0)); // Student{2023001, 홍길동, 1학년, 컴퓨터공학, 남}
    }
}
