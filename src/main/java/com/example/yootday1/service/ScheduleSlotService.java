package com.example.yootday1.service;

import com.example.yootday1.common.exception.NotFoundException;
import com.example.yootday1.dto.scheduleSlot.ScheduleSlotResponse;
import com.example.yootday1.dto.scheduleSlot.ScheduleSlotUpsertRequest;

import java.util.List;
import java.util.Optional;

public interface ScheduleSlotService {
    List<ScheduleSlotResponse> findAll();
    Optional<ScheduleSlotResponse> findById(long id);
    ScheduleSlotResponse create(ScheduleSlotUpsertRequest req);
    ScheduleSlotResponse update(Long id, ScheduleSlotUpsertRequest req);
    void delete(Long id) throws NotFoundException;
}
