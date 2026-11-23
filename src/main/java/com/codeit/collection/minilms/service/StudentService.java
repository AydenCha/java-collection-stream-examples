package com.codeit.collection.minilms.service;

import com.codeit.collection.minilms.domain.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StudentService {

    private final List<Student> students;

    public StudentService(List<Student> students) {
        this.students = students;
    }

    // TODO: 교안 11장의 요구사항에 맞춰 메서드를 작성하세요.
}
