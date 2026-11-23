package com.codeit.collection.minilms.service;

import com.codeit.collection.minilms.domain.Course;
import com.codeit.collection.minilms.domain.Enrollment;
import com.codeit.collection.minilms.domain.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportService {

    private final StudentService studentService;
    private final CourseService courseService;
    private final EnrollmentService enrollmentService;

    public ReportService(StudentService studentService, CourseService courseService,
                         EnrollmentService enrollmentService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.enrollmentService = enrollmentService;
    }

    // TODO: 교안 11장의 요구사항에 맞춰 메서드를 작성하세요.
}
