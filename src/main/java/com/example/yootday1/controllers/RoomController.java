package com.example.yootday1.controllers;


import com.example.yootday1.common.ApiResponse;
import com.example.yootday1.common.exception.NotFoundException;
import com.example.yootday1.dto.room.RoomResponse;
import com.example.yootday1.dto.room.RoomUpsertRequest;
import com.example.yootday1.service.RoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rooms")
public class RoomController {
    private final RoomService roomService;
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ApiResponse<List<RoomResponse>> findAll(){
        return ApiResponse.success(roomService.findAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'ACADEMIC_STAFF')")
    public ApiResponse<RoomResponse> findById(@PathVariable Long id){
//         roomService.findById(id).map(ApiResponse::success)
//                .orElseGet(()-> ApiResponse.error("Not found", new RoomResponse()));
        Optional<RoomResponse> roomResponse = roomService.findById(id);
        if(roomResponse.isPresent()){
            return ApiResponse.success(roomResponse.get());
        }else {
            return ApiResponse.error("Room not found", new RoomResponse());
        }
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'ACADEMIC_STAFF')")
    public ApiResponse<RoomResponse> create(@Valid @RequestBody RoomUpsertRequest req){
        return ApiResponse.success(roomService.create(req));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'ACADEMIC_STAFF')")
    public ApiResponse<RoomResponse> update(@PathVariable Long id,@Valid @RequestBody RoomUpsertRequest req){
        return ApiResponse.success(roomService.update(id, req));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ApiResponse<?> delete(@PathVariable Long id) throws NotFoundException {
        roomService.delete(id);
        return ApiResponse.successMessage("Xoa Thanh Cong");
    }
}
