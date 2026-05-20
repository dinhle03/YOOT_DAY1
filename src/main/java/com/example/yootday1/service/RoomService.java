package com.example.yootday1.service;

import com.example.yootday1.common.exception.NotFoundException;
import com.example.yootday1.dto.room.RoomResponse;
import com.example.yootday1.dto.room.RoomUpsertRequest;

import java.util.List;
import java.util.Optional;

public interface RoomService {

    List<RoomResponse> findAll();
    Optional<RoomResponse> findById(long id);
    RoomResponse create(RoomUpsertRequest req);
    RoomResponse update(Long id, RoomUpsertRequest req);
    void delete(Long id) throws NotFoundException;
}
