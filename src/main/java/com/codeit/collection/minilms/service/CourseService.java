package com.codeit.collection.minilms.service;

import com.codeit.collection.minilms.domain.Course;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CourseService {

    private final List<Course> courses;

    public CourseService(List<Course> courses) {
        this.courses = courses;
    }

    // TODO: 교안 11장의 요구사항에 맞춰 메서드를 작성하세요.
}
