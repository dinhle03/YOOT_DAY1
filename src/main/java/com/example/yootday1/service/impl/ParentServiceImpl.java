package com.example.yootday1.service.impl;

import com.example.yootday1.common.exception.NotFoundException;
import com.example.yootday1.domain.entity.Parent;
import com.example.yootday1.dto.parent.ParentResponse;
import com.example.yootday1.dto.parent.ParentUpsertRequest;
import com.example.yootday1.repository.ParentRepository;
import com.example.yootday1.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParentServiceImpl implements ParentService {
    private final ParentRepository parentRepository;
    private final ModelMapper mapper;

    private ParentResponse map(Parent parent){
        return mapper.map(parent, ParentResponse.class);
    }

    public List<ParentResponse> findAll(){
        return parentRepository.findAll().stream()
                .map(s->map(s)).toList();
    }

    public Optional<ParentResponse> findById(Long id){
        return parentRepository.findById(id)
                .map(this::map);

    }

    public ParentResponse create(ParentUpsertRequest req){
        Parent parent = mapper.map(req, Parent.class);
        parent.setCreatedAt(LocalDateTime.now());
        parent.setUpdatedAt(LocalDateTime.now());
        Parent result = parentRepository.save(parent);
        return map(result);
    }

    public ParentResponse update(Long id, ParentUpsertRequest req){
        Parent parent = mapper.map(req, Parent.class);
        parent.setId(id);
        parent.setCreatedAt(LocalDateTime.now());
        parent.setUpdatedAt(LocalDateTime.now());
        Parent result = parentRepository.save(parent);
        return map(result);
    }

    public void delete(Long id) throws NotFoundException {
        if(parentRepository.existsById(id)){
            parentRepository.deleteById(id);
        }else {
            throw new NotFoundException("Delete error");
        }
    }
}
