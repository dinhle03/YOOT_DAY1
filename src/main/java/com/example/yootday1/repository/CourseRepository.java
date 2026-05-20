package com.example.yootday1.repository;

import com.example.yootday1.domain.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("SELECT o FROM Course o WHERE o.isActive=1")
    List<Course> findByCourseActive();
}
