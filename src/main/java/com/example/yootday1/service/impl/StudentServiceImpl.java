package com.example.yootday1.service.impl;

import com.example.yootday1.domain.entity.Student;
import com.example.yootday1.repository.StudentRepository;
import com.example.yootday1.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }
}
