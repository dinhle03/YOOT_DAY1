package com.example.yootday1.controllers;

import com.example.yootday1.common.ApiResponse;
import com.example.yootday1.common.exception.NotFoundException;
import com.example.yootday1.dto.courseClass.CourseClassResponse;
import com.example.yootday1.dto.courseClass.CourseClassUpsertRequest;
import com.example.yootday1.service.CourseClassService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course-classes")
@RequiredArgsConstructor
public class CourseClassController {
    private final CourseClassService courseClassService;

    @GetMapping
    public ApiResponse<List<CourseClassResponse>> findAll() {
        return ApiResponse.success(courseClassService.findAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<CourseClassResponse> findById(@PathVariable Long id) {
        return courseClassService.findById(id)
                .map(ApiResponse::success)
                .orElseGet(() -> ApiResponse.error("Not found", new CourseClassResponse()));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'ACADEMIC_STAFF')")
    public ApiResponse<CourseClassResponse> create(@Valid @RequestBody CourseClassUpsertRequest req) {
        return ApiResponse.success(courseClassService.create(req));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'ACADEMIC_STAFF')")
    public ApiResponse<CourseClassResponse> update(@PathVariable Long id, @Valid @RequestBody CourseClassUpsertRequest req) throws NotFoundException {
        return ApiResponse.success(courseClassService.update(id, req));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<?> delete(@PathVariable Long id) throws NotFoundException {
        courseClassService.delete(id);
        return ApiResponse.successMessage("Xoa Thanh Cong");
    }
}
