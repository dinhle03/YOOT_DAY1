package com.example.yootday1.service.impl;

import com.example.yootday1.common.exception.NotFoundException;
import com.example.yootday1.domain.entity.Room;
import com.example.yootday1.dto.room.RoomResponse;
import com.example.yootday1.dto.room.RoomUpsertRequest;
import com.example.yootday1.repository.RoomRepository;
import com.example.yootday1.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    private final ModelMapper mapper;

    private RoomResponse map(Room room){
        return mapper.map(room, RoomResponse.class);
    }

    public List<RoomResponse> findAll(){
        return roomRepository.findAll().stream()
                .map(r->map(r)).toList();
    }

    public Optional<RoomResponse> findById(long id){
        return roomRepository.findById(id).map(this::map);
    }

    public RoomResponse create(RoomUpsertRequest req){
        Room room = mapper.map(req, Room.class);
        Room response = roomRepository.save(room);
        return map(response);
    }

    public RoomResponse update(Long id, RoomUpsertRequest req){
        Room room = mapper.map(req, Room.class);
        room.setId(id);
        Room response = roomRepository.save(room);
        return map(response);
    }

    public void delete(Long id) throws NotFoundException {
        if (roomRepository.existsById(id)){
            roomRepository.deleteById(id);
        }else {
            throw new NotFoundException("Delete error");
        }
    }
}
