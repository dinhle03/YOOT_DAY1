package com.example.yootday1.controllers;

import com.example.yootday1.common.ApiResponse;
import com.example.yootday1.domain.entity.Course;
import com.example.yootday1.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    @GetMapping
    public ResponseEntity<ApiResponse<List<Course>>> getCourse(){
        return ResponseEntity.ok(ApiResponse.success(courseService.findAll()));
    }
    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<Course>> getCourseById(@PathVariable("id") Long id){
        Optional<Course> course = courseService.findById(id);
//        return course.map(value ->
//                ResponseEntity.ok(ApiResponse.success(value)))
//                .orElseGet(() -> ResponseEntity.notFound().build());
        if(course.isPresent()){
            return ResponseEntity.ok(ApiResponse.success(course.get()));
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<ApiResponse<Course>> create(@RequestBody Course course){
        return ResponseEntity.ok(ApiResponse.success(courseService.save(course)));
    }
}
