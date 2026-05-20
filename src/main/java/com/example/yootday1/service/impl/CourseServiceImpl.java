package com.example.yootday1.service.impl;

import com.example.yootday1.common.exception.NotFoundException;
import com.example.yootday1.domain.entity.Course;
import com.example.yootday1.dto.course.CourseResponse;
import com.example.yootday1.dto.course.CourseUpsertRequest;
import com.example.yootday1.repository.CourseRepository;
import com.example.yootday1.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final ModelMapper mapper;

    private CourseResponse map(Course course){
        return mapper.map(course, CourseResponse.class);
    }

    public List<CourseResponse> findAll(){
        return courseRepository.findAll().stream()
                .map(r->map(r)).toList();
    }

    public List<CourseResponse> findByCourseActive(){
        return courseRepository.findByCourseActive().stream()
                .map(r->map(r)).toList();
    }

    public Optional<CourseResponse> findById(Long id){
        return courseRepository.findById(id).map(this::map);
    }

    public CourseResponse create(CourseUpsertRequest req){
        Course course = mapper.map(req, Course.class);
        Course response = courseRepository.save(course);
        return map(response);
    }

    public CourseResponse update(Long id, CourseUpsertRequest req){
        Course course = mapper.map(req, Course.class);
        course.setId(id);
        Course response = courseRepository.save(course);
        return map(response);
    }

    public void delete(Long id) throws NotFoundException {
        if (courseRepository.existsById(id)){
            courseRepository.deleteById(id);
        }else {
            throw new NotFoundException("Delete error");
        }
    }
}
