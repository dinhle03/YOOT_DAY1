package com.example.yootday1.controllers;

import com.example.yootday1.common.ApiResponse;
import com.example.yootday1.common.exception.NotFoundException;
import com.example.yootday1.dto.scheduleSlot.ScheduleSlotResponse;
import com.example.yootday1.dto.scheduleSlot.ScheduleSlotUpsertRequest;
import com.example.yootday1.service.ScheduleSlotService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
@RequiredArgsConstructor
public class ScheduleSlotController {
    private final ScheduleSlotService scheduleSlotService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'ACADEMIC_STAFF')")
    public ApiResponse<List<ScheduleSlotResponse>> findAll(){
        return ApiResponse.success(scheduleSlotService.findAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'ACADEMIC_STAFF')")
    public ApiResponse<ScheduleSlotResponse> findById(@PathVariable Long id){
        return scheduleSlotService.findById(id).map(ApiResponse::success)
                .orElseGet(()-> ApiResponse.error("Not found", new ScheduleSlotResponse()));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'ACADEMIC_STAFF')")
    public ApiResponse<ScheduleSlotResponse> create(@Valid @RequestBody ScheduleSlotUpsertRequest req){
        return ApiResponse.success(scheduleSlotService.create(req));
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'ACADEMIC_STAFF')")
    public ApiResponse<ScheduleSlotResponse> update(@PathVariable Long id,@Valid @RequestBody ScheduleSlotUpsertRequest req){
        return ApiResponse.success(scheduleSlotService.update(id,req));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ApiResponse<?> delete(@PathVariable Long id) throws NotFoundException {
        scheduleSlotService.delete(id);
        return ApiResponse.successMessage("Xoa Thanh Cong");
    }
}
