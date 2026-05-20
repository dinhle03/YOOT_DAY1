package com.example.yootday1.controllers;

import com.example.yootday1.common.ApiResponse;
import com.example.yootday1.common.exception.NotFoundException;
import com.example.yootday1.dto.course.CourseResponse;
import com.example.yootday1.dto.course.CourseUpsertRequest;
import com.example.yootday1.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    @GetMapping
    public ApiResponse<List<CourseResponse>> findAll(){
        return ApiResponse.success(courseService.findAll());
    }
    @GetMapping("/{id}")
    public ApiResponse<CourseResponse> findById(@PathVariable Long id){
        return courseService.findById(id).map(ApiResponse::success)
                .orElseGet(()-> ApiResponse.error("Not found", new CourseResponse()));
    }
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'ACADEMIC_STAFF')")
    public ApiResponse<CourseResponse> create(@Valid @RequestBody CourseUpsertRequest req){
        return ApiResponse.success(courseService.create(req));
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'ACADEMIC_STAFF')")
    public ApiResponse<CourseResponse> update(@PathVariable Long id,@Valid @RequestBody CourseUpsertRequest req){
        return ApiResponse.success(courseService.update(id,req));
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ApiResponse<?> delete(@PathVariable Long id) throws NotFoundException {
        courseService.delete(id);
        return ApiResponse.successMessage("Xoa Thanh Cong");
    }
}
