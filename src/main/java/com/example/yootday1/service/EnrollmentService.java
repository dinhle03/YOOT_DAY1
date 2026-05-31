package com.example.yootday1.service;

import com.example.yootday1.common.exception.BadRequestException;
import com.example.yootday1.domain.entity.Enrollment;
import com.example.yootday1.dto.enrollment.EnrollmentResponse;
import com.example.yootday1.dto.enrollment.EnrollmentCreateRequest;

import java.util.List;

public interface EnrollmentService {
    EnrollmentResponse create(EnrollmentCreateRequest request);
    List<EnrollmentResponse> findByClassId(Long classId);
    List<EnrollmentResponse> findByStudentId(Long studentId);
    Enrollment getEnrollment(Long studentId, Long classId) throws BadRequestException;
    EnrollmentResponse drop(Long id);
}
