package com.example.yootday1.service;

import com.example.yootday1.common.exception.BadRequestException;
import com.example.yootday1.common.exception.NotFoundException;
import com.example.yootday1.dto.learningresult.LearningResultCreateRequest;
import com.example.yootday1.dto.learningresult.LearningResultResponse;

import java.util.List;

public interface LearningResultService {
    LearningResultResponse create(LearningResultCreateRequest request, String username);
    List<LearningResultResponse> findByStudentId(Long studentId, String username) throws BadRequestException, NotFoundException;
}
