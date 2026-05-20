package com.example.yootday1.service.impl;

import com.example.yootday1.common.exception.NotFoundException;
import com.example.yootday1.domain.entity.ScheduleSlot;
import com.example.yootday1.dto.scheduleSlot.ScheduleSlotResponse;
import com.example.yootday1.dto.scheduleSlot.ScheduleSlotUpsertRequest;
import com.example.yootday1.repository.ScheduleSlotRepository;
import com.example.yootday1.service.ScheduleSlotService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleSlotServiceImpl implements ScheduleSlotService {
    private final ScheduleSlotRepository scheduleSlotRepository;
    private final ModelMapper mapper;

    private ScheduleSlotResponse map(ScheduleSlot scheduleSlot){
        return mapper.map(scheduleSlot, ScheduleSlotResponse.class);
    }

    public List<ScheduleSlotResponse> findAll(){
        return scheduleSlotRepository.findAll().stream()
                .map(r->map(r)).toList();
    }

    public Optional<ScheduleSlotResponse> findById(long id){
        return scheduleSlotRepository.findById(id).map(this::map);
    }

    public ScheduleSlotResponse create(ScheduleSlotUpsertRequest req){
        ScheduleSlot scheduleSlot = mapper.map(req, ScheduleSlot.class);
        ScheduleSlot response = scheduleSlotRepository.save(scheduleSlot);
        return map(response);
    }

    public ScheduleSlotResponse update(Long id, ScheduleSlotUpsertRequest req){
        ScheduleSlot scheduleSlot = mapper.map(req, ScheduleSlot.class);
        scheduleSlot.setId(id);
        ScheduleSlot response = scheduleSlotRepository.save(scheduleSlot);
        return map(response);
    }

    public void delete(Long id) throws NotFoundException {
        if (scheduleSlotRepository.existsById(id)){
            scheduleSlotRepository.deleteById(id);
        }else {
            throw new NotFoundException("Delete error");
        }
    }

}
