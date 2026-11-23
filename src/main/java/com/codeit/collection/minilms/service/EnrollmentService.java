package com.codeit.collection.minilms.service;

import com.codeit.collection.minilms.domain.Enrollment;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class EnrollmentService {

    private final List<Enrollment> enrollments;

    public EnrollmentService(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    // TODO: 교안 11장의 요구사항에 맞춰 메서드를 작성하세요.
}
