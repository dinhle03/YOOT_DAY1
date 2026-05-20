package com.example.yootday1.service;

import com.example.yootday1.common.exception.NotFoundException;
import com.example.yootday1.dto.course.CourseResponse;
import com.example.yootday1.dto.course.CourseUpsertRequest;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<CourseResponse> findAll();
    List<CourseResponse> findByCourseActive();
    Optional<CourseResponse> findById(Long id);
    CourseResponse create(CourseUpsertRequest req);
    CourseResponse update(Long id, CourseUpsertRequest req);
    void delete(Long id) throws NotFoundException;
}
