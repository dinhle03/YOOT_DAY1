package com.example.yootday1.controllers;

import com.example.yootday1.common.ApiResponse;
import com.example.yootday1.common.exception.NotFoundException;
import com.example.yootday1.dto.student.StudentResponse;
import com.example.yootday1.dto.student.StudentUpsertRequest;
import com.example.yootday1.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentsController {
    private final StudentService studentService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'ACADEMIC_STAFF')")
    public ApiResponse<List<StudentResponse>> findAll() {
        return ApiResponse.success(studentService.findAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'ACADEMIC_STAFF', 'PARENT')")
    public ApiResponse<StudentResponse> findById(@PathVariable Long id) {
        return studentService.findById(id).map(ApiResponse::success)
                .orElseGet(()-> ApiResponse.error("Not found", new StudentResponse()));

    }
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'ACADEMIC_STAFF')")
    public ApiResponse<StudentResponse> create(@Valid @RequestBody StudentUpsertRequest req){
        return ApiResponse.success(studentService.create(req));
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'ACADEMIC_STAFF')")
    public ApiResponse<StudentResponse> update(@PathVariable Long id,@Valid @RequestBody StudentUpsertRequest req){
        return ApiResponse.success(studentService.update(id,req));
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ApiResponse<?> delete(@PathVariable Long id) throws NotFoundException {
        studentService.delete(id);
        return ApiResponse.successMessage("Xoa Thanh Cong");
    }
}