package com.example.yootday1.controllers;

import com.example.yootday1.common.ApiResponse;
import com.example.yootday1.common.exception.NotFoundException;
import com.example.yootday1.dto.teacher.TeacherResponse;
import com.example.yootday1.dto.teacher.TeacherUpsertRequest;
import com.example.yootday1.service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'ACADEMIC_STAFF')")
    public ApiResponse<List<TeacherResponse>> findAll(){
        return ApiResponse.success(teacherService.findAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'ACADEMIC_STAFF', 'TEACHER')")
    public ApiResponse<TeacherResponse> findById(@PathVariable Long id){
        return teacherService.findById(id).map(ApiResponse::success)
                .orElseGet(()-> ApiResponse.error("Not found", new TeacherResponse()));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ApiResponse<TeacherResponse> create(@Valid @RequestBody TeacherUpsertRequest req){
        return ApiResponse.success(teacherService.create(req));
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'ACADEMIC_STAFF')")
    public ApiResponse<TeacherResponse> update(@PathVariable Long id,@Valid @RequestBody TeacherUpsertRequest req){
        return ApiResponse.success(teacherService.update(id,req));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ApiResponse<?> delete(@PathVariable Long id) throws NotFoundException {
        teacherService.delete(id);
        return ApiResponse.successMessage("Xoa Thanh Cong");
    }
}
