package com.example.yootday1.service;

import com.example.yootday1.common.exception.NotFoundException;
import com.example.yootday1.dto.parent.ParentResponse;
import com.example.yootday1.dto.parent.ParentUpsertRequest;

import java.util.List;
import java.util.Optional;

public interface ParentService {
    List<ParentResponse> findAll();
    Optional<ParentResponse> findById(Long id);
    ParentResponse create(ParentUpsertRequest req);
    ParentResponse update(Long id, ParentUpsertRequest req);
    void delete(Long id) throws NotFoundException;
}
