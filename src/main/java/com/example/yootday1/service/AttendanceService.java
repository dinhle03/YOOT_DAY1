package com.example.yootday1.service;

import com.example.yootday1.common.exception.BadRequestException;
import com.example.yootday1.common.exception.NotFoundException;
import com.example.yootday1.dto.attendance.AttendanceCreateRequest;
import com.example.yootday1.dto.attendance.AttendanceResponse;

import java.util.List;

public interface AttendanceService {
    AttendanceResponse create(AttendanceCreateRequest request, String username) throws BadRequestException, NotFoundException;
    List<AttendanceResponse> findByClassId(Long classId);
}
