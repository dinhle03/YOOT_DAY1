package com.example.yootday1.controllers;

import com.example.yootday1.domain.entity.Student;
import com.example.yootday1.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HomeController {
    private final StudentService studentService;
    @GetMapping
    public ResponseEntity<String> home(){
        return ResponseEntity.ok("\"data\": \"This is my content\"");
    }
    @GetMapping(value = "/students")
    public ResponseEntity<List<Student>> findAll(){
        return ResponseEntity.ok(studentService.findAll());
    }
}
