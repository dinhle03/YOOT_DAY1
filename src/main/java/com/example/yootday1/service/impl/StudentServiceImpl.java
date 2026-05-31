package com.example.yootday1.service.impl;

import com.example.yootday1.common.exception.NotFoundException;
import com.example.yootday1.domain.entity.Student;
import com.example.yootday1.dto.student.StudentResponse;
import com.example.yootday1.dto.student.StudentUpsertRequest;
import com.example.yootday1.repository.ParentRepository;
import com.example.yootday1.repository.StudentRepository;
import com.example.yootday1.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ParentRepository parentRepository;
    private final ModelMapper mapper;
    private StudentResponse map(Student student){
        return mapper.map(student, StudentResponse.class);
    }
    public List<StudentResponse> findAll(){
        return studentRepository.findAll().stream()
                .map(s->map(s)).toList();
    }

    public Optional<StudentResponse> findById(long id){
        return studentRepository.findById(id)
                .map(this::map);
    }

    public StudentResponse create(StudentUpsertRequest req){
        Student stu = mapper.map(req, Student.class);
        parentRepository.findById(req.getParentId())
                .ifPresent(p->stu.setParent(p));
        stu.setCreatedAt(LocalDateTime.now());
        stu.setUpdatedAt(LocalDateTime.now());
        Student result = studentRepository.save(stu);
        return map(result);
    }
    public StudentResponse update(Long id,StudentUpsertRequest req){
        Student stu = mapper.map(req, Student.class);
        stu.setId(id);
        parentRepository.findById(req.getParentId())
                .ifPresent(p->stu.setParent(p));
        stu.setCreatedAt(LocalDateTime.now());
        stu.setUpdatedAt(LocalDateTime.now());
        Student result = studentRepository.save(stu);
        return map(result);
    }

    public void delete(Long id) throws NotFoundException {
        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
        }else {
            throw new NotFoundException("Delete error");
        }
    }

    @Transactional(readOnly = true)
    public Student getStudentForParent(Long studentId, Long parentId) throws NotFoundException {
        Student student = getStudent(studentId);
        if (student.getParent() == null || !student.getParent().getId().equals(parentId)) {
            throw new org.springframework.security.access.AccessDeniedException("Student does not belong to current parent account");
        }
        return student;
    }

    public Student getStudent(Long id) throws NotFoundException {
        return studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Student not found: " + id));
    }

    @Transactional(readOnly = true)
    public List<StudentResponse> findByParentId(Long parentId) {
        return studentRepository.findByParentId(parentId).stream().map(this::map).toList();
    }
}
