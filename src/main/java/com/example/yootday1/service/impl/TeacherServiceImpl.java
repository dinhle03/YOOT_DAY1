package com.example.yootday1.service.impl;

import com.example.yootday1.common.exception.NotFoundException;
import com.example.yootday1.domain.entity.Teacher;
import com.example.yootday1.dto.teacher.TeacherResponse;
import com.example.yootday1.dto.teacher.TeacherUpsertRequest;
import com.example.yootday1.repository.TeacherRepository;
import com.example.yootday1.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final ModelMapper mapper;

    private TeacherResponse map(Teacher teacher){
        return mapper.map(teacher, TeacherResponse.class);
    }

    public List<TeacherResponse> findAll(){
        return teacherRepository.findAll()
                .stream().map(s->map(s)).toList();
    }

    public Optional<TeacherResponse> findById(Long id){
        return teacherRepository.findById(id).map(this::map);
    }

    public TeacherResponse create(TeacherUpsertRequest req){
        Teacher teacher = mapper.map(req, Teacher.class);
        teacher.setCreatedAt(LocalDateTime.now());
        teacher.setUpdatedAt(LocalDateTime.now());
        Teacher result = teacherRepository.save(teacher);
        return map(result);
    }

    public TeacherResponse update(Long id, TeacherUpsertRequest req){
        Teacher teacher = mapper.map(req, Teacher.class);
        teacher.setId(id);
        teacher.setCreatedAt(LocalDateTime.now());
        teacher.setUpdatedAt(LocalDateTime.now());
        Teacher result = teacherRepository.save(teacher);
        return map(result);
    }

    public void delete(Long id) throws NotFoundException {
        if (teacherRepository.existsById(id)){
            teacherRepository.deleteById(id);
        }else {
            throw new NotFoundException("Delete error");
        }
    }
}
