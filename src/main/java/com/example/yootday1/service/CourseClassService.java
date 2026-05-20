package com.example.yootday1.service;

import com.example.yootday1.common.exception.NotFoundException;
import com.example.yootday1.dto.courseClass.CourseClassResponse;
import com.example.yootday1.dto.courseClass.CourseClassUpsertRequest;

import java.util.List;
import java.util.Optional;

public interface CourseClassService {
    List<CourseClassResponse> findAll();
    Optional<CourseClassResponse> findById(Long id);
    CourseClassResponse create(CourseClassUpsertRequest req);
    CourseClassResponse update(Long id, CourseClassUpsertRequest req) throws NotFoundException;
    void delete(Long id) throws NotFoundException;
}
