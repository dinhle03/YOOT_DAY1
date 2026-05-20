package com.example.yootday1.service;

import com.example.yootday1.common.exception.NotFoundException;
import com.example.yootday1.dto.teacher.TeacherResponse;
import com.example.yootday1.dto.teacher.TeacherUpsertRequest;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    List<TeacherResponse> findAll();
    Optional<TeacherResponse> findById(Long id);
    TeacherResponse create(TeacherUpsertRequest req);
    TeacherResponse update(Long id, TeacherUpsertRequest req);
    void delete(Long id) throws NotFoundException;
}
