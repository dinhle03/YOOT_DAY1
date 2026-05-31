package com.example.yootday1.controllers;

import com.example.yootday1.common.ApiResponse;
import com.example.yootday1.dto.enrollment.EnrollmentResponse;
import com.example.yootday1.dto.enrollment.EnrollmentCreateRequest;
import com.example.yootday1.service.EnrollmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','ACADEMIC_STAFF')")
    public ApiResponse<EnrollmentResponse> create(@Valid @RequestBody EnrollmentCreateRequest request) {
        return ApiResponse.success("Enrollment created", enrollmentService.create(request));
    }

    @GetMapping("/class/{classId}")
    public ApiResponse<List<EnrollmentResponse>> findByClassId(@PathVariable Long classId) {
        return ApiResponse.success(enrollmentService.findByClassId(classId));
    }

    @GetMapping("/student/{stuId}")
    public ApiResponse<List<EnrollmentResponse>> findByStudentId(@PathVariable Long stuId) {
        return ApiResponse.success(enrollmentService.findByStudentId(stuId));
    }

    @PatchMapping("/{id}/drop")
    @PreAuthorize("hasRole('ACADEMIC_STAFF')")
    public ApiResponse<EnrollmentResponse> drop(@PathVariable Long id) {
        return ApiResponse.success("Dropped successfully", enrollmentService.drop(id));
    }
}
