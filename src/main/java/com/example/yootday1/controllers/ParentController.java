package com.example.yootday1.controllers;

import com.example.yootday1.common.ApiResponse;
import com.example.yootday1.common.exception.NotFoundException;
import com.example.yootday1.dto.parent.ParentResponse;
import com.example.yootday1.dto.parent.ParentUpsertRequest;
import com.example.yootday1.service.ParentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parents")
@RequiredArgsConstructor
public class ParentController {
    private final ParentService parentService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'ACADEMIC_STAFF')")
    public ApiResponse<List<ParentResponse>> findAll(){
        return ApiResponse.success(parentService.findAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'ACADEMIC_STAFF')")
    public ApiResponse<ParentResponse> findById(@PathVariable Long id){
        return parentService.findById(id).map(ApiResponse::success)
                .orElseGet(()-> ApiResponse.error("Not found", new ParentResponse()));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'ACADEMIC_STAFF')")
    public ApiResponse<ParentResponse> create(@Valid @RequestBody ParentUpsertRequest req){
        return ApiResponse.success(parentService.create(req));
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'ACADEMIC_STAFF')")
    public ApiResponse<ParentResponse> update(@PathVariable Long id,@Valid @RequestBody ParentUpsertRequest req){
        return ApiResponse.success(parentService.update(id,req));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ApiResponse<?> delete(@PathVariable Long id) throws  NotFoundException{
        parentService.delete(id);
        return ApiResponse.successMessage("Xoa Thanh Cong");
    }
}
